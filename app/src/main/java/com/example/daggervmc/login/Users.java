package com.example.daggervmc.login;

public class Users {

    private int id;
    private String FirtsName;
    private String Lastname;

    public Users(String firtsName, String lastname) {
        FirtsName = firtsName;
        Lastname = lastname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirtsName() {
        return FirtsName;
    }

    public void setFirtsName(String firtsName) {
        FirtsName = firtsName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public Users(int id, String firtsName, String lastname) {
        this.id = id;
        FirtsName = firtsName;
        Lastname = lastname;
    }
}
