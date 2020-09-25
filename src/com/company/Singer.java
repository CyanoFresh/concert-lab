package com.company;

public class Singer extends Artist {
    private String genre;

    public Singer(String name, String phone, int popularity, int teamPersons, boolean needAccommodation, String genre) {
        super(name, phone, popularity, teamPersons, needAccommodation);
        this.genre = genre;
    }

    @Override
    public void perform() {
        System.out.println(name + " is singing in " + genre + " genre");
    }
}
