package com.example.jobboard_final.forms;

import javax.validation.constraints.NotBlank;

public class LoginForm {
    @NotBlank(message = "Please enter username")
    private  String username;
    @NotBlank(message = "Please enter password")
    private String password;

    public LoginForm() {
    }

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
