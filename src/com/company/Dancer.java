package com.company;

public class Dancer extends Artist {
    private String style;

    public Dancer(String name, String phone, int popularity, int teamPersons, boolean needAccommodation, String style) {
        super(name, phone, popularity, teamPersons, needAccommodation);
        this.style = style;
    }

    @Override
    public void perform() {
        System.out.println(name + " is dancing in " + style + " style");
    }
}
