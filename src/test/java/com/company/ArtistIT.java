package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ArtistIT {
    @Test
    public void ArtistPersonsShouldTeamPersonsCountPlusOne() {
        int personsCount = 5;
        var team = spy(new ArtistTeam(personsCount, true));
        var artist = new Dancer("Test Name", "098", 10, team, "hip-hop");

        assertEquals(artist.getPersonsCount(), personsCount + 1);

        verify(team).getPersonsCount();
    }
}
