package com.example.demo.domain;

public class Albums {

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

    @Override
    public String toString() {
        return "albums{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
