package com.basejava.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection {

    private final List<String> skills;

    public ListSection(List<String> achievments) {
        this.skills = achievments;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return skills != null ? skills.equals(that.skills) : that.skills == null;
    }

    @Override
    public int hashCode() {
        return skills != null ? skills.hashCode() : 0;
    }
}
