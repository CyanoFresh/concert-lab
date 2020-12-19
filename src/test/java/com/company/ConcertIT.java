package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConcertIT {
    @Test
    public void MockCalendarShouldReturnDateString() {
        var gregorianCalendar = mock(GregorianCalendar.class);
        var concert = new Concert("Rock and Dance", gregorianCalendar, 2000);

        var time = System.currentTimeMillis();
        var returnedDate = new Date(time);

        when(gregorianCalendar.getTimeInMillis()).thenReturn(time);

        assertEquals(concert.getDate().getTime(), returnedDate);
        verify(gregorianCalendar).getTime();
    }
}
