package com.company;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DancerIT {
    @Test(expected = NotPerformableException.class)
    public void MockDancerFailToPerformWithInstrument() {
        var dancer = mock(Dancer.class);
        var instrument = new Instrument("Guitar", InstrumentType.String);

        when(dancer.perform(instrument)).thenThrow(NotPerformableException.class);

        dancer.perform(instrument);
    }
}
