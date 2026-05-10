package com.qaxpert.utils;

import com.qaxpert.models.Data;
import com.qaxpert.models.RegisterRequest;

public class DataFactory {

    public static RegisterRequest registerANewUserSuccessfully(){
        return buildRegisterRequest(
                "aprendiz1001@qaxpert.com"
                ,"12345"
                ,"Lopez"
                ,"Bolivia"
                ,"+59169784025");
    }

    public static RegisterRequest registerAUserWithExistingEmail(){
        return buildRegisterRequest(
                "aprendiz1001@qaxpert.com"
                ,"123456"
                ,"lopez"
                ,"Bolivia"
                ,"+59169784025");
    }

    public static RegisterRequest customRegisterUser(
            String email,
            String password,
            String fullname,
            String country,
            String wp){
        return buildRegisterRequest(email,password,fullname,country,wp);
    }

    private static RegisterRequest buildRegisterRequest(String email, String password, String fullname, String country, String wp){
        Data data = new Data();
        data.setFullname(fullname);
        data.setCountry(country);
        data.setWp(wp);
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(email);
        registerRequest.setPassword(password);
        registerRequest.setData(data);
        return registerRequest;
    }

}
