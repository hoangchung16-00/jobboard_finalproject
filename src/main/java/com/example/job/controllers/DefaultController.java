package com.example.job.controllers;


import com.example.job.configs.RestFB;
import com.example.job.entities.Account;
import com.example.job.forms.LoginForm;
import com.example.job.forms.RegisterForm;
import com.example.job.services.AccountRoleService;
import com.example.job.services.AccountService;
import com.example.job.services.CompanyService;
import com.example.job.services.UserService;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@Controller
public class DefaultController extends BaseController{
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRoleService accountRoleService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RestFB restFb;

    @GetMapping("/404")
    public String getErrorNotFound(){
        return "404";
    }

    @GetMapping("/login")
    public String getLogin(Model model, @RequestParam(value = "error",defaultValue = "false") boolean error){

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

    @GetMapping("/userType")
    public String getUserType(){
        return "userType";
    }

    @GetMapping("/registerRecruit")
    public String getRegisterRecruit(Model model){
        model.addAttribute("registerForm",new RegisterForm());
        return "registerRecruit";
    }

    @PostMapping("/registerRecruit")
    public String postRegisterRecruit(@Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        if(!registerForm.getPassword().equals(registerForm.getRepassword())){
            bindingResult.rejectValue("repassword","error.user","Password not match");
        }
        if(companyService.existsByEmail(registerForm.getEmail())){
            bindingResult.rejectValue("email","error.user","Email has been register");
        }
        if(bindingResult.hasErrors()){
            return "registerRecruit";
        }
        Account account = accountService.registerUser(registerForm,accountRoleService.getById(2L));
        companyService.register(registerForm,account,getSiteURL(request));
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("registerForm",new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        if(!registerForm.getPassword().equals(registerForm.getRepassword())){
            bindingResult.rejectValue("repassword","error.user","Password not match");
        }
        if(userService.existsByEmail(registerForm.getEmail())){
            bindingResult.rejectValue("email","error.user","Email has been register");
        }
        if(bindingResult.hasErrors()){
            return "register";
        }
        Account account = accountService.registerUser(registerForm,accountRoleService.getById(1L));
        userService.register(registerForm,account,getSiteURL(request));
        return "redirect:/login";
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

    @GetMapping("/verify")
    public String getVerify(@RequestParam("code") String code){
        if(code==null){
            return "redirect:/404";
        }
        if(accountService.existsByVerificationcode(code)){
            Account account = accountService.findByVerificationcode(code);
            accountService.verify(account);
            return "redirect:/";
        }

        return "redirect:/404";
    }

    @GetMapping("/test")
    public String getTest(){
        return "test";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }


}
