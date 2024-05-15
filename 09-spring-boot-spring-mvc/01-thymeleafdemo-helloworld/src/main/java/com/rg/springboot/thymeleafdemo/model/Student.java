package com.rg.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {
    public Student(){}

    String firstName;
    String lastName;
    String country;
    String language;
    List<String> favOperatingSystem;
    public String getCountry(){return country;}
    public void setCountry(String country){this.country=country;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getFavOperatingSystem() {
        return favOperatingSystem;
    }

    public void setFavOperatingSystem(List<String> favOperatingSystem) {
        this.favOperatingSystem = favOperatingSystem;
    }
}
