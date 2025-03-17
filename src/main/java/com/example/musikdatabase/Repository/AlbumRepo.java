package com.example.musikdatabase.Repository;

import com.example.musikdatabase.Model.Album;
import com.example.musikdatabase.Model.Tracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepo {
    @Autowired
    JdbcTemplate template;


    public List<Album> fetchAll(){
        String sql = "SELECT a.album_id, a.title, a.release_year, a.pladeselskab, k.name AS artist_name " +
                "FROM album a " +
                "JOIN kunstner k ON a.kunstner_id = k.kunstner_id " +
                "ORDER BY a.release_year DESC";

        List<Album> albums = template.query(sql, (rs, rowNum) -> {
            Album album = new Album();
            album.setAlbum_id(rs.getInt("album_id"));
            album.setTitle(rs.getString("title"));
            album.setRelease_year(rs.getInt("release_year"));
            album.setPladeselskab(rs.getString("pladeselskab"));
            album.setKunstner_name(rs.getString("artist_name"));
            List<Tracks> tracks = fetchTracksByAlbumId(album.getAlbum_id());
            album.setTracks(tracks);
            return album;
        });
        return albums;
    }

    private List<Tracks> fetchTracksByAlbumId(int albumId) {
        String sql = "SELECT track_id, title, spilletid, album_id FROM tracks WHERE album_id = ?";
        return template.query(sql, new Object[]{albumId}, (rs, rowNum) -> {
            Tracks track = new Tracks();
            track.setTrack_id(rs.getInt("track_id"));
            track.setTitle(rs.getString("title"));
            track.setSpilletid(rs.getInt("spilletid"));
            track.setAlbum_id(rs.getInt("album_id"));
            return track;
        });
    }

    public void addAlbum(Album a){
        String sql = "INSERT INTO album (album_id, title, kunstner_id, release_year, pladeselskab) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, a.getAlbum_id(), a.getTitle(), a.getKunstner_id(), a.getRelease_year(), a.getPladeselskab());
    }



}
