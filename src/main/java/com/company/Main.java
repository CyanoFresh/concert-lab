package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var concert = createConcert();
        printConcert(concert);
    }

    private static Concert createConcert() {
        var date = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        var concert = new Concert("Rock and Dance", date, 2000);

        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        var rammstein = new Singer("Rammstein", "+1000076001", 10, 10, true, "Rock");
        var trs = new Singer("The Rolling Stones", "+100000002", 7, 6, true, "Rock");
        concert.inviteArtist(acdc);
        concert.inviteArtist(rammstein);
        concert.inviteArtist(trs);

        var vv = new Dancer("Владимир Варнава", "+70005400", 4, 8, false, "Hip hop");
        var mg = new Dancer("Martha Graham", "+100066801", 6, 12, true, "Own");
        var fa = new Dancer("Fred Astaire", "+10013002", 7, 6, true, "Musical Comedian");
        concert.inviteArtist(vv);
        concert.inviteArtist(mg);
        concert.inviteArtist(fa);

        if (vv.equals(mg)) {
            logger.debug("Two artists are the same");
        } else {
            logger.debug("Two artists are not the same");
        }

        var mark = new Staff(StaffType.Engineer, "Mark");
        var dan = new Staff(StaffType.Stewart, "Dan");
        var bob = new Staff(StaffType.Organizer, "Bob");

        dan.getConnectedArtists().add(acdc);
        dan.getConnectedArtists().add(rammstein);
        bob.getConnectedArtists().add(trs);
        bob.getConnectedArtists().add(vv);
        bob.getConnectedArtists().add(mg);

        concert.addStaff(mark);
        concert.addStaff(dan);
        concert.addStaff(bob);
        concert.addStaff(bob);

        return concert;
    }

    private static void printConcert(Concert concert) {
        logger.info("Concert: " + concert.getTitle());
        logger.info("Maximum cashbox capacity: $" + concert.getCashbox());
        logger.info("Date: " + concert.getDate().getTime());
        logger.info("\nInstrument Types: ");
        InstrumentType.printDescriptionsList();

        logger.info("\nProgram: ");

        var instruments = new ArrayList<Instrument>();
        instruments.add(new Instrument("Guitar", InstrumentType.String));

        var sb = new StringBuilder();

        var iterator = concert.getArtists().iterator();
        while (iterator.hasNext()) {
            var artist = iterator.next();

            try {
                logger.info(artist.perform(instruments.get(0)));
            } catch (NotPerformableException e) {
                logger.info(e.getMessage());
            } finally {
                logger.info(artist.perform());
            }

            sb.append(artist.getName());
            sb.append(", ");
        }

        logger.info("\nList of performed artists: " + sb);

        logger.info("\nStaff during performance: \n");

        for (Staff staff : concert.getStaff()) {
            logger.info(staff);
        }

        var concertRepository = new ConcertRepository(concert);

        logger.info("Sum of singer team count: " + concertRepository.sumSingerTeamCount());
        logger.info("Average staff artist popularity: " + concertRepository.calcAverageStaffArtistsRating());
        logger.info("Most popular Artist: " + concertRepository.getMostPopularArtist());

        concertRepository
                .groupArtistByPopularity(ConcertRepository.singerArtists())
                .forEach((key, value) -> logger.info(key + ": " + value));
    }
}
