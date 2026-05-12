package com.qaxpert.utils;
import com.qaxpert.models.Data;
import com.qaxpert.models.RegisterRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterDataFactory {

    public static RegisterRequest registerANewUserSuccessfully(){
        String uniqueEmail = "aprendiz" + System.currentTimeMillis() + "@qaxpert.com";
        return buildRegisterRequest(
                uniqueEmail
                ,"12345678"
                ,"Lopez"
                ,"Bolivia"
                ,"+59169784025");
    }

    public static RegisterRequest registerAUserWithExistingEmail(){
        return buildRegisterRequest(
                "aprendiz1001@qaxpert.com"
                ,"123456"
                ,"Aprendiz Ninja For Testing"
                ,"Colombia"
                ,"+573001112233");
    }

    public static RegisterRequest customRegisterUser(
            String email,
            String password,
            String fullname,
            String country,
            String wp){
        return buildRegisterRequest(email,password,fullname,country,wp);
    }

    private static RegisterRequest buildRegisterRequest(
            String email,
            String password,
            String fullname,
            String country,
            String wp){
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

    public static String generateRandomEmail(){
        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        return "test_" + timeStamp + "@email.com";
    }

}




