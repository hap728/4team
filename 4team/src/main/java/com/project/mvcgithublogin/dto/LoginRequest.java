package com.project.mvcgithublogin.dto;

public class LoginRequest {
    private String id;
    private String pw;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return this.pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
