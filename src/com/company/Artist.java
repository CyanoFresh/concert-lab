package com.company;

public abstract class Artist implements Performable {
    protected String name;
    protected String phone;
    protected int popularity;
    protected ArtistTeam team;

    public Artist(String name, String phone, int popularity, int teamPersons, boolean needAccommodation) {
        this.name = name;
        this.phone = phone;
        this.popularity = popularity;

        this.team = new ArtistTeam(teamPersons, needAccommodation);
    }
}
