package com.qaxpert.models.login;

import java.util.List;

public class User {

    private String id;
    private String aud;
    private String role;
    private String email;
    private String email_confirmed_at;
    private String phone;
    private String confirmed_at;
    private String last_sign_in_at;
    private AppMetadata app_metadata;
    private UserMetadata user_metadata;
    private List<Identity> identities;
    private String created_at;
    private String updated_at;
    private Boolean is_anonymous;

    public User() {
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAud() { return aud; }
    public void setAud(String aud) { this.aud = aud; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEmail_confirmed_at() { return email_confirmed_at; }
    public void setEmail_confirmed_at(String email_confirmed_at) { this.email_confirmed_at = email_confirmed_at; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getConfirmed_at() { return confirmed_at; }
    public void setConfirmed_at(String confirmed_at) { this.confirmed_at = confirmed_at; }

    public String getLast_sign_in_at() { return last_sign_in_at; }
    public void setLast_sign_in_at(String last_sign_in_at) { this.last_sign_in_at = last_sign_in_at; }

    public AppMetadata getApp_metadata() { return app_metadata; }
    public void setApp_metadata(AppMetadata app_metadata) { this.app_metadata = app_metadata; }

    public UserMetadata getUser_metadata() { return user_metadata; }
    public void setUser_metadata(UserMetadata user_metadata) { this.user_metadata = user_metadata; }

    public List<Identity> getIdentities() { return identities; }
    public void setIdentities(List<Identity> identities) { this.identities = identities; }

    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }

    public Boolean getIs_anonymous() { return is_anonymous; }
    public void setIs_anonymous(Boolean is_anonymous) { this.is_anonymous = is_anonymous; }
}