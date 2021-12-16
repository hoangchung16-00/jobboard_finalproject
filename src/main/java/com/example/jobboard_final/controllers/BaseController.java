package com.example.jobboard_final.controllers;

import com.example.jobboard_final.entities.Account;
import com.example.jobboard_final.entities.AccountRole;
import com.example.jobboard_final.entities.MyUserDetails;
import com.example.jobboard_final.entities.Users;
import com.example.jobboard_final.services.AccountRoleService;
import com.example.jobboard_final.services.AccountService;
import com.example.jobboard_final.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
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
