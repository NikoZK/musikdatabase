package com.example.musikdatabase.Repository;
import com.example.musikdatabase.Model.Kunstner;
import com.example.musikdatabase.Model.Tracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class KunstnerRepo {
    @Autowired
    JdbcTemplate template;

    public List<Kunstner> fetchAll() {
        String sql = "SELECT * FROM kunstner";
        return template.query(sql, new BeanPropertyRowMapper<>(Kunstner.class));
    }

    public List<Tracks> fetchByAlbumId(int albumId) {
        String sql = "SELECT * FROM tracks WHERE album_id = ?";
        return template.query(sql, new Object[]{albumId}, new BeanPropertyRowMapper<>(Tracks.class));
    }

    public void addKunstner(Kunstner k) {
        String sql = "INSERT INTO kunstner (name, land) VALUES (?, ?)";
        template.update(sql, k.getName(), k.getLand());
    }
}