package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExceptionsTest {
    @Test(expected = NotPerformableException.class)
    public void DancerFailToPerformWithInstrument() {
        Dancer dancer = new Dancer("Name", "+380", 10, 3, true, "Hip hop");
        var instrument = new Instrument("Guitar", InstrumentType.String);

        dancer.perform(instrument);
    }

    @Test
    public void DancerPerformsWithoutInstrument() {
        Dancer dancer = new Dancer("Name", "+380", 10, 3, true, "Hip hop");

        String result = dancer.perform();

        assertEquals(dancer.name + " is dancing in " + dancer.style + " style", result);
    }
}
