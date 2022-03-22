package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Albums {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String artist;
    private int songCount;
    private String imageUrl;

    public Albums(String title, String artist, int songCount, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.imageUrl = imageUrl;
    }

    public Albums() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }


}
