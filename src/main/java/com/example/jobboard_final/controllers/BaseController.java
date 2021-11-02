package com.example.jobboard_final.controllers;

import com.example.jobboard_final.entities.Account;
import com.example.jobboard_final.entities.MyUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
    @ModelAttribute("isLogin")
    public boolean getUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof MyUserDetails || principal instanceof UserDetails) {
            return true;
        }
        return false;
    }
    @ModelAttribute("account")
    public Account getUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof MyUserDetails){
            return ((MyUserDetails) principal).getUser();
        }
        return null;
    }
}
