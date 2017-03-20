package com.devandroid.clucle.mvp_pattern_tutor.model;

public class User {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name : " + name;
    }
}
