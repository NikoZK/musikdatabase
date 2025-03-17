package com.example.musikdatabase.Model;

public class Kunstner {
private int kunstner_id;
private String name;
private String land;

    public int getKunstner_id() {
        return kunstner_id;
    }

    public String getName() {
        return name;
    }

    public String getLand() {
        return land;
    }


    public void setKunstner_id(int kunstner_id) {
        this.kunstner_id = kunstner_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLand(String land) {
        this.land = land;
    }

}
