package com.example.job.controllers;

import com.example.job.entities.Job;
import com.example.job.entities.MyUserDetails;
import com.example.job.entities.Status;
import com.example.job.services.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Controller
public class AjaxController {
    @Autowired
    private RequestRecruitService requestRecruitService;

    @Autowired
    private JobServices jobServices;

    @Autowired
    private StatusService statusService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @ResponseBody
    @GetMapping("/apply")
    public String getApply(@RequestParam("id") Long id){
        if(!jobServices.existsById(id)){
            return "redirect:/404";
        }
        Gson gson = new Gson();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof MyUserDetails) {
            if (requestRecruitService.existByUserAndJob(((MyUserDetails) principal).getUser().getUser().getId(), id)) {
                String message = "2";
                return gson.toJson(message);
            }
            Job job = jobServices.getJobById(id);
            Status status = statusService.getById(3L);
            if (requestRecruitService.apply(job, ((MyUserDetails) principal).getUser().getUser(), status)) {
                String message = "1";
                return gson.toJson(message);
            }
        }
        if(principal instanceof User) {
            if (requestRecruitService.existByUserAndJob(((User) principal).getUsername(), id)) {
                String message = "2";
                return gson.toJson(message);
            }
            Job job = jobServices.getJobById(id);
            Status status = statusService.getById(3L);
            if (requestRecruitService.apply(job,userService.findByIdsocial(((User) principal).getUsername()) , status)) {
                String message = "1";
                return gson.toJson(message);
            }
        }
        String message = "0";
        return gson.toJson(message);
    }

    @ResponseBody
    @GetMapping("/deny")
    public String getDeny(@RequestParam("id") Long id) throws UnsupportedEncodingException, MessagingException {
        if(!requestRecruitService.existsById(id)){
            return "redirect:/404";
        }
        requestRecruitService.setRequestStatus(id,statusService.getById(2L));
        emailService.sendDenyEmail(requestRecruitService.getById(id).getJob().getCompany(),requestRecruitService.getById(id).getUser());
        String message = "This request has been denied";
        Gson gson = new Gson();
        return gson.toJson(message);
    }

    @ResponseBody
    @GetMapping("/accept")
    public String getAccept(@RequestParam("id") Long id) throws UnsupportedEncodingException, MessagingException {
        if(!requestRecruitService.existsById(id)){
            return "redirect:/404";
        }
        requestRecruitService.setRequestStatus(id,statusService.getById(1L));
        emailService.sendDenyEmail(requestRecruitService.getById(id).getJob().getCompany(),requestRecruitService.getById(id).getUser());
        String message = "This request has been accept";
        Gson gson = new Gson();
        return gson.toJson(message);
    }

}
