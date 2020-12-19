package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SingerIT {
    @Test
    public void PerformResultWithMockInstrument() {
        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        var instrument = mock(Instrument.class);

        when(instrument.getFullName()).thenReturn("Test Instrument");

        assertEquals(acdc.perform(instrument), "AC/DC is singing in Rock genre using Test Instrument instrument");
        verify(instrument).getFullName();
    }
}
