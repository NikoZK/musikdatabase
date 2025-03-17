package com.example.musikdatabase.Model;

import java.sql.Time;

public class Tracks {
    private int track_id;
    private String title;
    private int album_id;
    private int spilletid;

    public int getTrack_id() {
        return track_id;
    }

    public String getTitle() {
        return title;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }
}
