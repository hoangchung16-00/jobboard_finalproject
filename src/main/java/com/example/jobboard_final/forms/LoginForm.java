package com.example.jobboard_final.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    @NotBlank(message = "Please enter username")
    private  String username;
    @NotBlank(message = "Please enter password")
    private String password;
}
