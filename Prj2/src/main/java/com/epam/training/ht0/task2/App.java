package com.epam.training.ht0.task2;

import com.epam.training.ht0.task2.music_info.Album;
import com.epam.training.ht0.task2.music_info.Song;
import com.epam.training.ht0.task2.util.FileUtils;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import java.util.*;


public class App {
    private static final String FILE_EXTENSION = ".mp3";

    public static final Logger logger = LogManager.getLogger(App.class.getName());
//    public static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {
        System.setProperty("log4j.configurationFile", "./src/main/resources/log4j2.xml");

        Set<File> directoriesList = new HashSet<File>();
        for (String arg : args) {
            File dir = new File(arg);
            if (dir.exists()) {
                directoriesList.add(dir);
            } else {
                logger.info("The path " + arg + " does not exists.");
            }
        }

        List<File> fileList = new ArrayList<>();

        for (File dir : directoriesList) {
            FileUtils.getFilesWithRequiredExtension(dir, FILE_EXTENSION, fileList);
        }

        List<Song> songsList = new ArrayList<>();

        for (File file: fileList) {
            try {
                songsList.add(new Song(file));
            } catch (UnsupportedTagException | InvalidDataException e) {
                logger.warn(e.getStackTrace());
            }
        }

        Map<String, List<Album>> artistAlbumsMap = new TreeMap<>();
//        List<Album> albums = new ArrayList<>();
//
//        for (Song song: songsList) {
//
//        }



//        File file = new File("./pom.xml");
//        FileInputStream fis = new FileInputStream(file);
//        HashCode hc = Files.asByteSource(file).hash(Hashing.sha1());
//        System.out.println("SHA-1: " + hc.toString());
//
//        String md5Hex = DigestUtils.md5Hex(fis);
//        System.out.println("MD5: " + md5Hex);

//        HashCode md5 = Files.hash(file, Hashing.md5());
//        byte[] md5Bytes = md5.asBytes();
//        String md5Hex = md5.toString();
//        FileInputStream fis = new FileInputStream(file);
//        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
//        fis.close();
//        System.out.println(md5);
    }
}
