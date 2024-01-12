package com.teachmeskills.finalassigment.log_writing;

import com.teachmeskills.finalassigment.const_interface.IFilesConst;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    public static void writeExecutionLog(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(IFilesConst.EXECUTION_LOG_PATH, true))) {
            writer.write(new Date().toString() + " --> " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeErrorLog(String errorMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(IFilesConst.ERROR_LOG_PATH, true))) {
            writer.write(new Date().toString() + " --> " + errorMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
