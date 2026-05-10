package com.qaxpert.models;

public class Identity {
    private String identity_id;
    private String id;
    private String user_id;
    private IdentityData identity_data;
    private String provider;
    private String last_sign_in_at;
    private String created_at;
    private String updated_at;
    private String email;

    public Identity() {

    }

    public String getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(String identity_id) {
        this.identity_id = identity_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public IdentityData getIdentity_data() {
        return identity_data;
    }

    public void setIdentity_data(IdentityData identity_data) {
        this.identity_data = identity_data;
    }

    public String getLast_sign_in_at() {
        return last_sign_in_at;
    }

    public void setLast_sign_in_at(String last_sign_in_at) {
        this.last_sign_in_at = last_sign_in_at;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

