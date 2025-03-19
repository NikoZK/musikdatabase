package com.example.musikdatabase.Service;
import com.example.musikdatabase.Model.Album;
import com.example.musikdatabase.Repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepo albumRepo;

    public List<Album> fetchAll(){
        return albumRepo.fetchAll();
    }

    //<th>Album ID</th>
    //<td th:text="${album.album_id}"></td>

    public void addAlbum(Album album) {
        albumRepo.addAlbum(album);

    }

    public void DeleteAlbum(Album album) {
        albumRepo.deleteAlbum(album);
    }

    public void UpdateAlbum(Album album) {
        albumRepo.updateAlbum(album);
    }
}
