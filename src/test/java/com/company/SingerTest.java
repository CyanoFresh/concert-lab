package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class SingerTest {
    @Test
    public void performOutput() {
        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");

        var result2 = acdc.perform();
        var desiredResult2 = "AC/DC is singing in Rock genre";

        assertEquals(result2, desiredResult2);
    }

    @Test
    public void performWithInstrumentOutput() {
        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        var instrument = new Instrument("Guitar", InstrumentType.String);

        var result1 = acdc.perform(instrument);
        var desiredResult1 = "AC/DC is singing in Rock genre using Guitar (String type - String instruments, stringed instruments, or chordophones are musical instruments that produce sound from vibrating strings when the performer plays or sounds the strings in some manner.) instrument";

        assertEquals(result1, desiredResult1);
    }
}
