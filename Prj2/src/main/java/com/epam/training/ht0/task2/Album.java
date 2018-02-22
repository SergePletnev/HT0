package com.epam.training.ht0.task2;

import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songs;
    private String name;

    public Album(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public boolean addSong(Song song) {
        boolean result = songs.add(song);
        return result;
    }
}
