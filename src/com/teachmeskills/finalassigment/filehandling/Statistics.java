package com.teachmeskills.finalassigment.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private List<String> processedFiles;
    private List<String> invalidFiles;

    public Statistics() {
        processedFiles = new ArrayList<>();
        invalidFiles = new ArrayList<>();
    }

    public void updateProcessedFiles(String fileName) {
        processedFiles.add(fileName);
    }

    public void updateInvalidFiles(String fileName) {
        invalidFiles.add(fileName);
    }

    public void saveReport() {
        try (PrintWriter writer = new PrintWriter("report.txt")) {
            writer.println("Статистика обработки файлов:");
            writer.println("---------------------------------------------");
            writer.println("Обработано файлов: " + processedFiles.size());
            writer.println("Невалидных файлов: " + invalidFiles.size());
            writer.println("---------------------------------------------");
            writer.println("Список обработанных файлов:");
            for (String file : processedFiles) {
                writer.println(file);
            }
            writer.println("---------------------------------------------");
            writer.println("Список невалидных файлов:");
            for (String file : invalidFiles) {
                writer.println(file);
            }
            writer.println("---------------------------------------------");
            System.out.println("Отчет сохранен в файл report.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при сохранении отчета: " + e.getMessage());
        }
    }

    public void moveInvalidFiles() {
        File invalidFolder = new File("invalid_files");
        invalidFolder.mkdir();

        for (String file : invalidFiles) {
            File source = new File(file);
            File destination = new File(invalidFolder, source.getName());
            source.renameTo(destination);
        }
    }
}
