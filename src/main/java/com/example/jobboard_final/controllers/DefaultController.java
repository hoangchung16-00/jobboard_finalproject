package com.example.jobboard_final.controllers;

import com.example.jobboard_final.forms.LoginForm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DefaultController extends BaseController{
    @GetMapping("/404")
    public String getErrorNotFound(){
        return "404";
    }
    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "login";
    }
    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }
}
