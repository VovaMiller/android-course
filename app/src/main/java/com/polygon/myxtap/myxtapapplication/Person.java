package com.polygon.myxtap.myxtapapplication;

public class Person {
    public static final int defaultIconsNum = 15;

    private String personName;
    private int personId;

    public Person(int id, String name) {
        personName = name;
        personId = id;
    }

    public int getId() {
        return personId;
    }

    public String getName() {
        return personName;
    }

    public String getIconString() {
        return "icon_person_default_" + String.valueOf((personId % defaultIconsNum) + 1);
    }
}
