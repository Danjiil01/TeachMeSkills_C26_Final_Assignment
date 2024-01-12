package com.teachmeskills.finalassigment.session;

import com.teachmeskills.finalassigment.const_interface.IAuthConst;

public class StorageMock {
    private final String login = IAuthConst.LOGIN;
    private final String password = IAuthConst.PASSWORD;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
