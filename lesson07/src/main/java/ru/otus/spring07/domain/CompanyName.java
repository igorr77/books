package ru.otus.spring07.domain;


import javax.persistence.Embeddable;

@Embeddable
public class CompanyName {
    private String fullName;
    private String shortName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
