package com.epam.training.ht0.task2;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;

import java.util.Comparator;

public class Song implements Comparator<Song> {
    private Mp3File mp3file;

    public int compare(Song song1, Song song2) {
        ID3v1 tag1 = null;
        if (mp3file.hasId3v1Tag()) {
            tag1 = song1.mp3file.getId3v1Tag();
        }
        if (mp3file.hasId3v2Tag()) {
            tag1 = song1.mp3file.getId3v2Tag();
        }
        String song1Information = tag1.getArtist() + tag1.getAlbum() + tag1.getTitle();
        ID3v1 tag2 = null;
        if (mp3file.hasId3v1Tag()) {
            tag2 = song2.mp3file.getId3v1Tag();
        }
        if (mp3file.hasId3v2Tag()) {
            tag2 = song2.mp3file.getId3v2Tag();
        }
        String song2Information = tag2.getArtist() + tag2.getAlbum() + tag2.getTitle();
        return song1Information.compareToIgnoreCase(song2Information);
    }
}
