package com.example.job.controllers;

import com.example.job.entities.Account;
import com.example.job.entities.AccountRole;
import com.example.job.entities.MyUserDetails;
import com.example.job.entities.Users;
import com.example.job.services.AccountRoleService;
import com.example.job.services.AccountService;
import com.example.job.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountRoleService accountRoleService;

    @Autowired
    private AccountService accountService;

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
        if(principal instanceof UserDetails){
            Users user = userService.findByIdsocial(((UserDetails) principal).getUsername());
            AccountRole accountRole = accountRoleService.getById(1L);
            return new Account(((UserDetails) principal).getUsername(),true,accountRole,user);
        }
        return null;
    }
}
