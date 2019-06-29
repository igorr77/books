package ru.otus.igorr.books.lesson23.security;

public enum AppRoles {

    ADMIN("ADMIN"),
    VIEW("VIEW"),
    EDIT("EDIT");


    private final String role;

    AppRoles(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
