package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.Set;
@JsonIgnoreProperties({"song"})
@Getter
@Setter
@Entity


public class Albums {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String artist;
    private int songCount;
    @Lob
    private String imageUrl;

    public Albums(String title, String artist, int songCount, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.imageUrl = imageUrl;
    }
    public Albums() {

    }


    @OneToMany (mappedBy = "albums")
    Set<Song> song;


}
