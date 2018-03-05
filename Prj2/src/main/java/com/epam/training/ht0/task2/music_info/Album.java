package com.epam.training.ht0.task2.music_info;

import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songs = new ArrayList<>();
    private String name;

    public Album(String name) {
        this.name = name;
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
