package com.teachmeskills.finalassigment.authentication;

import com.teachmeskills.finalassigment.exceptions.AuthenticationException;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, String> users;

    public AuthService() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public void authenticate(String username, String password) throws AuthenticationException {
        if (users.containsKey(username)) {
            if (users.get(username).equals(password)) {
                System.out.println("Аутентификация прошла успешно!");
            } else {
                throw new AuthenticationException("Неверный пароль");
            }
        } else {
            throw new AuthenticationException("Пользователь не найден");
        }
    }
}