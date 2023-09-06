package ru.sberbank.utils;

public enum Locale {
    ENG("ENG"),
    RUS("РУС");

    private String name;

    Locale(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
