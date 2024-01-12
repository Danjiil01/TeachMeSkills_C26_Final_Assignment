package com.teachmeskills.finalassigment.filehandling;

import com.teachmeskills.finalassigment.const_interface.IFilesConst;
import com.teachmeskills.finalassigment.log_writing.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    public String[] parseFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(IFilesConst.FILE_PATH))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            Logger.writeErrorLog("Error while reading the input file: " + "\n" + e.getMessage());
            return new String[0];
        }
    }
}
