package com.epam.training.ht0.task2;

import java.io.File;
import java.util.*;

public class Runner {
    private static final String FILE_EXTENSION = ".mp3";

    public static void main(String[] args) {
        Set<String> directoriesList = new HashSet<String>();
        directoriesList.addAll(Arrays.asList(args).subList(0, args.length - 2));

        List<File> filesListByExtension = new ArrayList<>();

        for (String dir : directoriesList) {
            File parentDir = new File(dir);
            FileUtils.getFilesWithRequiredExtension(parentDir, FILE_EXTENSION, filesListByExtension);
        }

    }
}
