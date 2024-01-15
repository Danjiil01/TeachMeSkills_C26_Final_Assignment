package com.teachmeskills.finalassigment.authentication;

import com.teachmeskills.finalassigment.exceptions.AuthenticationException;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, String> users;

    public AuthService() {  // Создаем базу данных пользователей
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public void authenticate(String username, String password) throws AuthenticationException {

        if (users.containsKey(username)) {  // Проверяем, существует ли пользователь в базе данных
            if (users.get(username).equals(password)) { // Проверяем, совпадает ли введенный пароль с паролем пользователя
                System.out.println("Аутентификация прошла успешно!");
            } else {
                throw new AuthenticationException("Неверный логин или пароль");
            }
        } else {
            throw new AuthenticationException("Пользователь не найден");
        }
    }
}