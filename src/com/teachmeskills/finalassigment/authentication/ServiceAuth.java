package com.teachmeskills.finalassigment.authentication;

import com.teachmeskills.finalassigment.log_writing.Logger;
import com.teachmeskills.finalassigment.session.Session;
import com.teachmeskills.finalassigment.session.StorageMock;

public class ServiceAuth {
    public static Session doLogin(String login, String password){
        StorageMock storageMock = new StorageMock();
        String loginFromStorage = storageMock.getLogin();
        String passwordFromStorage = storageMock.getPassword();

        if(login.equals(loginFromStorage) && password.equals(passwordFromStorage)){
            System.out.printf("Вход выполнен успешно");
            Logger.writeExecutionLog("Пользователь зашел в программу");
            return new Session();
        }else{
            System.out.printf("Проблемы с аутентификацией");
            Logger.writeExecutionLog("Пользователь не прошел аутентификацию");
            return null;
        }
        //TODO дописать полный подходящий функционал сессии, добавить её в Main
    }
}
