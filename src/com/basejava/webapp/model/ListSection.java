package com.basejava.webapp.model;

import java.util.List;

public class ListSection extends UserInformation {

    private final List<String> achievements;

    public ListSection(List<String> achievments) {
        this.achievements = achievments;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return achievements != null ? achievements.equals(that.achievements) : that.achievements == null;
    }

    @Override
    public int hashCode() {
        return achievements != null ? achievements.hashCode() : 0;
    }
}
