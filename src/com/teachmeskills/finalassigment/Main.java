package com.teachmeskills.finalassigment;

import com.teachmeskills.finalassigment.authentication.AuthService;
import com.teachmeskills.finalassigment.exceptions.AuthenticationException;
import com.teachmeskills.finalassigment.filehandling.FileHandler;
import com.teachmeskills.finalassigment.filehandling.Statistics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AuthService authService = new AuthService();
        FileHandler fileHandler = new FileHandler();
        Statistics statistics = new Statistics();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        try {
            authService.authenticate(login, password);

            System.out.print("Введите путь к папке с финансовыми документами: ");
            String folderPath = scanner.nextLine();
            fileHandler.processFiles(folderPath, statistics);

            statistics.saveReport();
            statistics.moveInvalidFiles();

            System.out.println("Обработка файлов завершена.");
        } catch (AuthenticationException e) {
            System.out.println("Ошибка аутентификации: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время обработки файлов: " + e.getMessage());
        }
    }
}