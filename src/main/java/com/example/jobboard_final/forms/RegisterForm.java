package com.example.jobboard_final.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {
    @NotBlank(message = "Please enter username")
    private String username;
    @NotBlank(message = "Please enter password")
    private String password;
    @NotBlank(message = "Please enter password")
    private String repassword;
    @NotBlank(message = "Please enter your name")
    private String name;
    @NotBlank(message = "Please enter email")
    @Email(message = "Invalid email")
    private String email;

}
