package com.example.musikdatabase.Repository;

import com.example.musikdatabase.Model.Tracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TracksRepo {
    @Autowired
    JdbcTemplate template;


    public List<Tracks> fetchAll() {
        String sql = "SELECT * FROM tracks";
        return template.query(sql, new BeanPropertyRowMapper<>(Tracks.class));
    }

    public List<Tracks> fetchByAlbumId(int albumId) {
        String sql = "SELECT * FROM tracks WHERE album_id = ?";
        return template.query(sql, new Object[]{albumId}, new BeanPropertyRowMapper<>(Tracks.class));
    }


    public List<Tracks> fetchByAlbum(int albumId) {
        String sql = "SELECT * FROM tracks WHERE album_id = ?";
        return template.query(sql, new Object[]{albumId}, new BeanPropertyRowMapper<>(Tracks.class));
    }

    public void addTrack(Tracks track) {
        String sql = "INSERT INTO tracks (title, album_id, spilletid) VALUES (?, ?, ?)";
        template.update(sql, track.getTitle(), track.getAlbum_id(), track.getSpilletid());
    }
}


