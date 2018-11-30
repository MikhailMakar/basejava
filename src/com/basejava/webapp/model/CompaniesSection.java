package com.basejava.webapp.model;

import java.util.List;

public class CompaniesSection extends AbstractSection {

    private final List<Company> list;

    public CompaniesSection(List<Company> list) {
        this.list = list;
    }

    public List<Company> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompaniesSection that = (CompaniesSection) o;

        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}
