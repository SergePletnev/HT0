package com.epam.training.ht0.task2.music_info;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;

public class Song implements Comparator<Song> {
    private String singer;
    private String album;
    private String songTitle;
    private String path;
    private String hash;

    public Song(File file) throws InvalidDataException, IOException, UnsupportedTagException {
        this.hash = Files.asByteSource(file).hash(Hashing.sha1()).toString();

        Mp3File mp3File = new Mp3File(file.getAbsolutePath());

        if (mp3File.hasId3v1Tag()) {
            ID3v1 tag = mp3File.getId3v1Tag();
            singer = tag.getArtist();
            album = tag.getAlbum();
            songTitle = tag.getTitle();
        } else if (mp3File.hasId3v2Tag()) {
            ID3v2 tag = mp3File.getId3v2Tag();
            singer = tag.getArtist();
            album = tag.getAlbum();
            songTitle = tag.getTitle();
        }

        if (singer == null || singer.equals("")) {
            singer = "Uknown singer";
        }
        if (album == null || album.equals("")) {
            album = "Uknown album";
        }
        if (songTitle == null || songTitle.equals("")) {
            songTitle = "Uknown title";
        }
        this.path = file.getAbsolutePath();
    }

    public String getHash() {
        return hash;
    }

    public String getSinger() {
        return singer;
    }

    public String getAlbum() {
        return album;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getPath() {
        return path;
    }

    public int compare(Song song1, Song song2) {
        String song1Information = song1.singer + song1.album + song1.songTitle;
        String song2Information = song2.singer + song2.album + song2.songTitle;
        return song1Information.compareToIgnoreCase(song2Information);
    }
}
