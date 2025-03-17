package com.example.musikdatabase.Service;

import com.example.musikdatabase.Model.Tracks;
import com.example.musikdatabase.Repository.TracksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TracksService {
    @Autowired
    private TracksRepo tracksRepo;

    public void addTrack(Tracks track) {
        tracksRepo.addTrack(track);
    }

    public List<Tracks> fetchByAlbumId(int albumId) {
        return tracksRepo.fetchByAlbumId(albumId);
    }

    public List<Tracks> fetchAll() {
        return tracksRepo.fetchAll();
    }
}
