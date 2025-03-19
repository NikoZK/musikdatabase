package com.example.musikdatabase.Model;
import java.util.List;

public class Album {
    private int album_id;
    private String title;
    private int kunstner_id;
    private String pladeselskab;
    private int release_year;
    private String kunstner_name;
    private List<Tracks> tracks;

    public int getAlbum_id() {
        return album_id;
    }

    public String getTitle() {
        return title;
    }

    public int getKunstner_id() {
        return kunstner_id;
    }

    public String getPladeselskab() {
        return pladeselskab;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String getKunstner_name() {
        return kunstner_name;
    }

    public List<Tracks> getTracks() {
        return tracks;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKunstner_id(int kunstner_id) {
        this.kunstner_id = kunstner_id;
    }

    public void setPladeselskab(String pladeselskab) {
        this.pladeselskab = pladeselskab;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setKunstner_name(String kunstner_name) {
        this.kunstner_name = kunstner_name;
    }

    public void setTracks(List<Tracks> tracks) {
        this.tracks = tracks;
    }
}

