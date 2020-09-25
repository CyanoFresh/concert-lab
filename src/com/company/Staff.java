package com.company;

public class Staff {
    private StaffType type;
    private String name;
    private Artist connectedArtist;

    public Staff(StaffType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "Staff member: " + name + " - " + type;

        if (connectedArtist != null) {
            s += " - artist: " + connectedArtist.name;
        }

        return s;
    }
}
