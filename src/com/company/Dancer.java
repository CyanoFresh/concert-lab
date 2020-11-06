package com.company;

public class Dancer extends Artist {
    private String style;

    public Dancer(String name, String phone, int popularity, int teamPersons, boolean needAccommodation, String style) {
        super(name, phone, popularity, teamPersons, needAccommodation);
        this.style = style;
    }

    @Override
    public String perform() {
        var sb = new StringBuilder();
        sb.append(getName());
        sb.append(" is dancing in ");
        sb.append(style);
        sb.append(" style");

        return sb.toString();
    }

    @Override
    public String perform(Instrument instrument) {
        throw new NotPerformableException();
    }
}
