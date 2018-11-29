package com.basejava.webapp.model;

public class TextSection extends UserInformation {

    private final String information;

    public TextSection(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return information != null ? information.equals(that.information) : that.information == null;
    }

    @Override
    public int hashCode() {
        return information != null ? information.hashCode() : 0;
    }
}
