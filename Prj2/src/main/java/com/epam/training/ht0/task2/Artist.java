package com.epam.training.ht0.task2;

import java.util.ArrayList;

public class Artist {
    private ArrayList<Album> albums;
    private String name;

    public Artist(String name) {
        this.name = name;
        albums = new ArrayList<Album>();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public String getName() {
        return name;
    }

    public boolean addAlbum(Album album) {
        boolean result = albums.add(album);
        return result;
    }
}
