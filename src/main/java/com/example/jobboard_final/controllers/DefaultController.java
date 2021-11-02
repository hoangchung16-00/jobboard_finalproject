package com.example.jobboard_final.controllers;


import com.example.jobboard_final.configs.RestFB;
import com.example.jobboard_final.forms.LoginForm;

import com.example.jobboard_final.services.UserService;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class DefaultController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private RestFB restFb;
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


    @RequestMapping("/signin/facebook")
    public String loginFacebook(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            return "redirect:/login?facebook=error";
        }
        String accessToken = restFb.getToken(code);

        com.restfb.types.User user = restFb.getUserInfo(accessToken);
        UserDetails userDetail = restFb.buildUser(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if(!userService.existsByIdsocial(user.getId())){
            userService.createUser(user.getName(),"user.png",user.getId());
        }
        return "redirect:/";
    }


}
