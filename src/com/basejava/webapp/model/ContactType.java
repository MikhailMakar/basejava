package com.basejava.webapp.model;

public enum ContactType {
    PHONE("Номер телефона"),
    SKYPE("Логин в скайпе"),
    MAIL("Электронная почта"),
    LINKEDIN("Аккаунт в LInkedIn"),
    GITHUB("Аккаунт на GitHub"),
    STACKOVERFLOW("Аккаунт на StackOverFlow"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
