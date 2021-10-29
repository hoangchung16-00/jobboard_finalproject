package com.example.jobboard_final.controllers;

import com.example.jobboard_final.entities.Account;
import com.example.jobboard_final.entities.MyUserDetails;
import com.example.jobboard_final.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserClientController extends BaseController{
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getProfile(Model model, @RequestParam("id") Long id){

        if(!userService.existsById(id) || ((Account) model.getAttribute("account")).getUser().getId()!=id){
            return "404";
        }
        model.addAttribute("user",userService.findUsersById(id));
        return "profile";
    }

}
