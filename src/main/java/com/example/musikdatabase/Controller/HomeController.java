package com.example.musikdatabase.Controller;
import com.example.musikdatabase.Model.Album;
import com.example.musikdatabase.Model.Kunstner;
import com.example.musikdatabase.Model.Tracks;
import com.example.musikdatabase.Service.AlbumService;
import com.example.musikdatabase.Service.KunstnerService;
import com.example.musikdatabase.Service.TracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private KunstnerService kunstnerService;

    @Autowired
    private TracksService tracksService;

    @GetMapping("/")
    public String index(Model model) {
        List<Album> albums = albumService.fetchAll();
        List<Kunstner> kunstnere = kunstnerService.fetchAll();
        List<Tracks> tracks = tracksService.fetchAll();

        model.addAttribute("albums", albums);
        model.addAttribute("kunstnere", kunstnere);
        model.addAttribute("tracks", tracks);

        return "home/index";
    }

    @GetMapping("/AddAlbum")
    public String addAlbumForm(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("kunstnere", kunstnerService.fetchAll());
        return "home/AddAlbum";
    }

    @PostMapping("/AddAlbum")
    public String addAlbum(@ModelAttribute Album album, Model model) {
        albumService.addAlbum(album);
        return "redirect:/";
    }

    @GetMapping("/AddArtist")
    public String showAddArtistForm() {
        return "home/AddArtist";
    }

    @PostMapping("/AddArtist")
    public String addArtist(@ModelAttribute Kunstner kunstner, Model model) {
            kunstnerService.addKunstner(kunstner);
        return "redirect:/";
    }

    @GetMapping("/AddTrack")
    public String showAddTrackForm(Model model) {
        model.addAttribute("albums", albumService.fetchAll());
        return "home/AddTrack";
    }

    @PostMapping("/AddTrack")
    public String addTrack(@ModelAttribute Tracks tracks, Model model) {
        tracksService.addTrack(tracks);

        return "redirect:/";
    }

    @GetMapping("/DeleteAlbum")
    public String showDeleteAlbumForm(Model model) {
        model.addAttribute("albums", albumService.fetchAll());
        return "home/DeleteAlbum";
    }

    @PostMapping("/DeleteAlbum")
    public String DeleteAlbum(@ModelAttribute Album album, Model model) {
        albumService.DeleteAlbum(album);

        return "redirect:/";
    }

    @GetMapping("/UpdateAlbum")
    public String showUpdateAlbumForm( Model model){
        model.addAttribute("albums", albumService.fetchAll());

        return "home/UpdateAlbum";
    }

    @PostMapping("/UpdateAlbum")
    public String UpdateAlbum(@ModelAttribute Album album, Model model) {
        albumService.UpdateAlbum(album);

        return "redirect:/";
    }

    @GetMapping("/DeleteTrack")
    public String showDeleteTrackForm(Model model) {
        model.addAttribute("tracks", tracksService.fetchAll());
        return "home/DeleteTrack";
    }

    @PostMapping("/DeleteTrack")
    public String deleteTrack(@RequestParam("track_id") int trackId) {
        tracksService.DeleteTrack(trackId);  // Call the service to delete track
        return "redirect:/";  // Redirect to home after deletion
    }
}
