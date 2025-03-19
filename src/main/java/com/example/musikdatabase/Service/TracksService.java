package com.example.musikdatabase.Service;
import com.example.musikdatabase.Model.Tracks;
import com.example.musikdatabase.Repository.TracksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TracksService {
    @Autowired
    TracksRepo tracksRepo;

    public void addTrack(Tracks tracks) {
        tracksRepo.addTrack(tracks);
    }

    public void DeleteTrack(int track_id) {
        tracksRepo.deleteTrack(track_id);
    }

    public List<Tracks> fetchAll() {
        return tracksRepo.fetchAll();
    }
}
