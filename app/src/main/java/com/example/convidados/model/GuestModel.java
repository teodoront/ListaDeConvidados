package com.example.convidados.model;

public class GuestModel {

    //Classe pessoa


    private int id;
    private String name;
    private int confrimation;


    public GuestModel(int id, String name, int confrimation) {
        this.id = id;
        this.name = name;
        this.confrimation = confrimation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConfrimation() {
        return confrimation;
    }

    public void setConfrimation(int confrimation) {
        this.confrimation = confrimation;
    }


}
