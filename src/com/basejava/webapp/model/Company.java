package com.basejava.webapp.model;

public class Company {

    private final String companyName;
    private final String startDate;
    private final String endDate;
    private final String position;
    private final String duties;

    public Company(String companyName, String startDate, String endDate, String position, String duties) {
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.duties = duties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (startDate != null ? !startDate.equals(company.startDate) : company.startDate != null) return false;
        if (endDate != null ? !endDate.equals(company.endDate) : company.endDate != null) return false;
        if (position != null ? !position.equals(company.position) : company.position != null) return false;
        return duties != null ? duties.equals(company.duties) : company.duties == null;
    }

    @Override
    public int hashCode() {
        int result = companyName != null ? companyName.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (duties != null ? duties.hashCode() : 0);
        return result;
    }
}
