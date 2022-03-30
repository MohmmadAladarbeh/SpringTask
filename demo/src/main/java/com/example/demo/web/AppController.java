package com.example.demo.web;

import com.example.demo.domain.Albums;
import com.example.demo.domain.Song;
import com.example.demo.infrastructure.AlbumsRepository;
import com.example.demo.infrastructure.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
public class AppController {

    final SongRepository songRepository;

    @Autowired
    AlbumsRepository albumsRepository;

    public AppController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping ("/hello")
    public String getHello () {
        return "hello";
    }

    @GetMapping ("/hello/{name}")
    String getCapitalize(@PathVariable String name, Model model ) {
        model.addAttribute("name", name.toUpperCase(Locale.ROOT));
        return "capitalize";
    }

    @GetMapping ("/")
    String rootRoute () {
        return "root";
    }

    @ResponseBody
    @GetMapping ("/albums")
    List<Albums> getAlbumss(long id){

        List<Albums> album = new ArrayList<>();

        album.add(new Albums("song1", "Eminem", 4, "https://image/eminem"));
        album.add(new Albums("song2", "Jesika", 6, "https://image/eminem"));
        album.add(new Albums("song3", "Eminem", 8, "https://image/eminem"));

        System.out.println(album);
        return album;
    }
    // Add Album
    @ResponseBody
    @PostMapping ("/album")
    Albums addAlbum (@RequestBody Albums albums){
        return albumsRepository.save(albums);
    }


    // Get All Album
    @GetMapping ("/albumpage")
    String addAlbumForm (Model model) {
        model.addAttribute("albumList", albumsRepository.findAll());
        return "formAlbum";
    }

    // Add New Album
    @PostMapping ("/addalbum")
    RedirectView createNemAlbum(@ModelAttribute Albums album){
        albumsRepository.save(album);
        return new RedirectView("albumpage");
    }




    // Add Songs
    @ResponseBody
    @PostMapping ("/song")
    Song addSong(@RequestBody Song song){
        return songRepository.save(song);
    }

    //Get All Songs
    @ResponseBody
    @GetMapping ("/song")
    List<Song> getAllSongs (){
        return songRepository.findAll();
    }


    // Get Specific Album
    @GetMapping ("/albumdetails/{id}")
    String getAllSongInAlbum (@PathVariable Long id, Model model){
        Albums album = albumsRepository.findById(id).orElseThrow();
        Set <Song> setOfSong = album.getSong();
        System.out.println(setOfSong);
        List<Song> songs = songRepository.findByAlbums(album);
        System.out.println(songs);
        model.addAttribute("song", songs);
        return "oneAlbum";
    }

    private long idd;


    @GetMapping ("/song/{id}")
    String addSongToModel (Model model, @PathVariable long id){
        idd = id;

        model.addAttribute("songsList", songRepository.findAll());
        return "songForm";
    }

    @ResponseBody
    @PostMapping ("/usersong")
    RedirectView userAddSong (@ModelAttribute Song song){

        Albums albums = albumsRepository.findById(idd).orElseThrow();
        song.setAlbums(albums);
        songRepository.save(song);
        return new RedirectView ("/song");
    }





}
