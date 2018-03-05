package com.epam.training.ht0.task2.music_info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Singer {
    private List<Album> albums = new ArrayList<>();
    private Map<Album, List<Song>> mapAlbums = new TreeMap<>();
    private String name;

    public Singer(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public String getName() {
        return name;
    }

}
