package com.teachmeskills.finalassigment.filehandling;

import com.teachmeskills.finalassigment.const_interface.IFilesConst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private List<String> processedFiles;  // список строк, содержащих имена обработанных файлов
    private List<String> invalidFiles;   // список строк, содержащих имена невалидных файлов

    public Statistics() {
        processedFiles = new ArrayList<>();
        invalidFiles = new ArrayList<>();
    }

    public void updateProcessedFiles(String fileName) {
        processedFiles.add(fileName);
    }   // метод для добавления нового обработанного файла

    public void updateInvalidFiles(String fileName) {
        invalidFiles.add(fileName);
    }   // метод для добавления нового невалидного файла

    public void saveReport() {         // метод для сохранения отчета в файл report.txt
        try (PrintWriter writer = new PrintWriter("report.txt")) {
            writer.println("Статистика обработки файлов:");
            writer.println("---------------------------------------------");
            writer.println("Обработано файлов: " + processedFiles.size());   // запись информации о количестве обработанных и невалидных файлов
            writer.println("Невалидных файлов: " + invalidFiles.size());
            writer.println("---------------------------------------------");
            writer.println("Список обработанных файлов:");
            for (String file : processedFiles) {  // запись списка обработанных файлов
                writer.println(file);
            }
            writer.println("---------------------------------------------");
            writer.println("Список невалидных файлов:");
            for (String file : invalidFiles) {   // запись списка невалидных файлов
                writer.println(file);
            }
            writer.println("---------------------------------------------");
            System.out.println("Отчет сохранен в файл report.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при сохранении отчета: " + e.getMessage());
        }
    }

    public void moveInvalidFiles() {  // метод для перемещения невалидных файлов в "invalid_files"
        File invalidFolder = new File(IFilesConst.INVALID_FILE_PATH);
        invalidFolder.mkdir();  // создание папки "invalid_files", если ее не созадли ранее

        for (String file : invalidFiles) {  // перемещение каждого невалидного файла в "invalid_files"
            File source = new File(file);
            File destination = new File(invalidFolder, source.getName());
            source.renameTo(destination);  // переименование файла и перемещение его в "invalid_files"
        }
    }
}
