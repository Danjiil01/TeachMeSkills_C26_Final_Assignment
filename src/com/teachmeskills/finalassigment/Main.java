package com.teachmeskills.finalassigment;

import com.teachmeskills.finalassigment.authentication.AuthService;
import com.teachmeskills.finalassigment.exceptions.AuthenticationException;
import com.teachmeskills.finalassigment.filehandling.FileHandler;
import com.teachmeskills.finalassigment.filehandling.Statistics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AuthService authService = new AuthService();  //создаются объекты AuthService, FileHandler и Statistics, которые выполняют проверку аутентификации, обработку файлов и сохранение отчета
        FileHandler fileHandler = new FileHandler();
        Statistics statistics = new Statistics();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");  //запрашиваем у пользователя логин и пароль
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        try {
            authService.authenticate(login, password);

            System.out.print("Введите путь к папке с финансовыми документами: "); // запрашиваем путь к папке с финансовыми документами
            String folderPath = scanner.nextLine();
            fileHandler.processFiles(folderPath, statistics);  //вызываетм метод processFiles объекта FileHandler, который обрабатывает файлы в указанной папке

            statistics.saveReport(); //Результаты сохраняются в отчете с помощью метода saveReport объекта Statistics
            statistics.moveInvalidFiles();  //невалидные файлы перемещаются в отдельную папку с помощью метода moveInvalidFiles

            System.out.println("Обработка файлов завершена.");
        } catch (AuthenticationException e) {
            System.out.println("Ошибка аутентификации: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время обработки файлов: " + e.getMessage());
        }
    }
}