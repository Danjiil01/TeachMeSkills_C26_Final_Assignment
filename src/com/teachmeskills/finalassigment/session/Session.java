package com.teachmeskills.finalassigment.session;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public final class Session {
    private String accessToken;
    private Date expiredDate;

    public boolean isSessionAlive(){
        if(this.accessToken.length() == 16 &&
                this.expiredDate.after(new Date())){
            return true;
        }else{
            return false;
        }
    }

    public Session() {
        setAccessToken();
        this.expiredDate = expiredDate;
    }

    private String setAccessToken(){
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 16; i++){
            int index = random.nextInt(symbols.length());
            sb.append(symbols.charAt(index));
        }

        return sb.toString();
    }

    private void setExpiredDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE,10);

        this.expiredDate = calendar.getTime();
    }
}
