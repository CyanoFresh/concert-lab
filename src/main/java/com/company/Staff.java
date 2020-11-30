package com.company;

public class Staff {
    protected final StaffType type;
    protected final String name;
    protected Artist connectedArtist;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Staff other = (Staff) obj;

        if (type != other.type)
            return false;

        return name.equals(other.name);
    }
}
