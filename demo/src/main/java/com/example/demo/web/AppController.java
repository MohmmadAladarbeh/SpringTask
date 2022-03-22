package com.example.demo.web;

import com.example.demo.domain.Albums;
import com.example.demo.infrastructure.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class AppController {

    @Autowired
    AlbumsRepository albumsRepository;

    @GetMapping ("/hello")
    String getHello () {
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
    List<Albums> getAlbums(){

        List<Albums> album = new ArrayList<>();

        album.add(new Albums("song1", "Eminem", 4, "https://image/eminem"));
        album.add(new Albums("song2", "Jesika", 6, "https://image/eminem"));
        album.add(new Albums("song3", "Eminem", 8, "https://image/eminem"));

        System.out.println(album);
        return album;
    }

    @GetMapping ("/albumpage")
    String addAlbumForm (Model model) {
        model.addAttribute("albumList", albumsRepository.findAll());
        return "formAlbum";
    }




    @PostMapping ("/addalbum")
    RedirectView createNemAlbum(@ModelAttribute Albums album){
        albumsRepository.save(album);
        return new RedirectView("albumpage");
    }
}
