package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Concert concert = createConcert();
        printConcert(concert);
    }

    private static Concert createConcert() {
        GregorianCalendar date = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        Concert concert = new Concert("Rock and Dance", date, 2000);

        Singer acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        Singer rammstein = new Singer("Rammstein", "+1000076001", 10, 10, true, "Rock");
        Singer trs = new Singer("The Rolling Stones", "+100000002", 7, 6, true, "Rock");
        concert.inviteArtist(acdc);
        concert.inviteArtist(rammstein);
        concert.inviteArtist(trs);

        Dancer vv = new Dancer("Владимир Варнава", "+70005400", 4, 8, false, "Hip hop");
        Dancer mg = new Dancer("Martha Graham", "+100066801", 6, 12, true, "Own");
        Dancer fa = new Dancer("Fred Astaire", "+10013002", 7, 6, true, "Musical Comedian");
        concert.inviteArtist(vv);
        concert.inviteArtist(mg);
        concert.inviteArtist(fa);

        concert.addStaff(new Staff(StaffType.Engineer, "Mark"));
        concert.addStaff(new Staff(StaffType.Stewart, "Dan"));
        concert.addStaff(new Staff(StaffType.Organizer, "Bob"));

        return concert;
    }

    private static void printConcert(Concert concert) {
        System.out.println("Concert: " + concert.getTitle());
        System.out.println("Maximum cashbox capacity: $" + concert.getCashbox());
        System.out.println("Date: " + concert.getDate().getTime());
        System.out.println("Program: ");

        Iterator<Artist> iterator = concert.getArtists().iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            artist.perform();
        }

        System.out.println("Staff during performance: ");

        for (Staff staff : concert.getStaff()) {
            System.out.println(staff);
        }
    }
}
