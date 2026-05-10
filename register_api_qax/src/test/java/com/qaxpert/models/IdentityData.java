package com.qaxpert.models;

public class IdentityData {
    private String country;
    private String email;
    private String email_verified;
    private String fullname;
    private String phone_verified;
    private String sub;
    private String wp;

    public IdentityData() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(String email_verified) {
        this.email_verified = email_verified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_verified() {
        return phone_verified;
    }

    public void setPhone_verified(String phone_verified) {
        this.phone_verified = phone_verified;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }
}
