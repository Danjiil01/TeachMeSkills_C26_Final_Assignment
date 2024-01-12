package com.teachmeskills.finalassigment.filehandling;

import java.io.File;

public class FileHandler {
    public void processFiles(String folderPath, Statistics statistics) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file, statistics);
                }
            }
        }
    }

    private void processFile(File file, Statistics statistics) {
        //TODO логика обработки каждого файла
    }
}