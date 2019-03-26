package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.Month;

public class ResumeTestData {

    public static Resume getWholeResume(String uuid, String fullname) {
        Resume resume = new Resume(uuid, fullname);
        resume.addContact(ContactType.MAIL, "mail1@ya.ru");
        resume.addContact(ContactType.PHONE, "11111");
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        resume.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        resume.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        resume.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));
        resume.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization3", "http://Organization3.ru",
                                new Organization.Position(2004, Month.JANUARY, 2005, Month.JANUARY, "position3", "content3"))));
        resume.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization4", "http://Organization4.ru",
                                new Organization.Position(2005, Month.FEBRUARY,2005, Month.AUGUST, "intern", "content4"))));
        resume.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization5", "http://Organization5.ru",
                                new Organization.Position(2009, Month.JUNE, 2010, Month.MARCH, "position5", "content5"))));
        return resume;
    }
}
