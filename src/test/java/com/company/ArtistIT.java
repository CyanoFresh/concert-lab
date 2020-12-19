package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ArtistIT {
    @Test
    public void ArtistPersonsShouldTeamPersonsCountPlusOne() {
        var team = spy(new ArtistTeam(10, true));
        var artist = new Dancer("Test Name", "098", 10, team, "hip-hop");

        var expectedPersonsCount = 5;

        when(team.getPersonsCount()).thenReturn(expectedPersonsCount);

        assertEquals(artist.getPersonsCount(), expectedPersonsCount + 1);
        verify(team).getPersonsCount();
    }
}
