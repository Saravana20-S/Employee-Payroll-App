package com.epa.empRegistration;

import java.util.Base64;

public class UserAccount {

    private String userName;
    private String encryptedPassword;

    public UserAccount(String userName, String rawPassword){
        this.userName = userName;
        this.encryptedPassword = encryptPassword(rawPassword);
    }

    public String encryptPassword(String password){
       return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String getUserName() {
        return userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    @Override
    public String toString(){
        return "UserName: "+ userName;
    }
}
