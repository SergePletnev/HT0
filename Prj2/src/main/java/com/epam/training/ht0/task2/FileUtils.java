package com.epam.training.ht0.task2;

import java.io.File;
import java.util.List;

public class FileUtils {

    public static void getFilesWithRequiredExtension(File parentDirectory, String fileExtension, List<File> resultList) {
        File[] files = parentDirectory.listFiles();
        if (files != null) {
            for (File dir : files) {
                if (dir.isFile() && dir.getName().endsWith(fileExtension)) {
                    resultList.add(dir);
                }
                if (dir.isDirectory()) {
                    getFilesWithRequiredExtension(dir, fileExtension, resultList);
                }
            }
        }
    }

}
