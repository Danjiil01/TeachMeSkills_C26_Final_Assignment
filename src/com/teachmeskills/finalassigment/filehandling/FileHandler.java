package com.teachmeskills.finalassigment.filehandling;

import java.io.File;

public class FileHandler {
    public void processFiles(String folderPath, Statistics statistics) {
        File folder = new File(folderPath);  // созданем объект File и получаем массив файлов
        File[] files = folder.listFiles();

        if (files != null) { // проверяем массив файлом
            for (File file : files) {
                if (file.isFile()) {  // проверяяем что текущий элемент массива является файлом
                    processFile(file, statistics); // вызываем метод processFile для обработки каждого файла и передаем файл и объект Statistics в качестве аргументов
                }
            }
        }
    }

    private void processFile(File file, Statistics statistics) {
        //TODO логика обработки каждого файла
    }
}