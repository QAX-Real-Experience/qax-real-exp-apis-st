package com.qaxpert.utils;

import com.qaxpert.models.login.LoginRequest;

public class DataFactory {
    public DataFactory() {
    }

    public static LoginRequest validEmailAndPassword(){
        return buildLoginRequest("aprendiz1001@qaxpert.com","12345678");
    }

    public static LoginRequest unregisteredUser(){
        return buildLoginRequest("unregistereduser"+ System.currentTimeMillis()+ "@email.com","4550");
    }

    public static LoginRequest emptyPassword(){
        return buildLoginRequest("aprendiz1001@qaxpert.com","");
    }
    public static LoginRequest emptyEmail(){
        return buildLoginRequest("","12345678");
    }
    public static LoginRequest invalidEmailAndPasswordFormat(){
        return buildLoginRequest("222","$%^");
    }

    private static LoginRequest buildLoginRequest(String email, String password){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        return loginRequest;
    }
}
