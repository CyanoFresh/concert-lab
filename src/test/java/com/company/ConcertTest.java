package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

public class ConcertTest {
    @Test
    public void DuplicatedStaffIsNotAddedToTheList() {
        var date = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        var concert = new Concert("Rock and Dance", date, 2000);

        var dan = new Staff(StaffType.Stewart, "Dan");
        var bob = new Staff(StaffType.Organizer, "Bob");

        concert.addStaff(bob);
        concert.addStaff(dan);
        concert.addStaff(bob);

        assertEquals(concert.getStaff(), new ArrayList<>(Arrays.asList(bob, dan)));
    }

    @Test
    public void DuplicatedArtistIsAddedToTheList() {
        var date = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        var concert = new Concert("Rock and Dance", date, 2000);

        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        var rammstein = new Singer("Rammstein", "+1000076001", 10, 10, true, "Rock");

        concert.inviteArtist(acdc);
        concert.inviteArtist(rammstein);
        concert.inviteArtist(acdc);

        assertEquals(concert.getArtists(), new ArrayList<>(Arrays.asList(acdc, rammstein, acdc)));
    }
}
