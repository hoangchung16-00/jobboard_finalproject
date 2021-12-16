package com.example.jobboard_final.controllers;

import com.example.jobboard_final.entities.Job;
import com.example.jobboard_final.entities.MyUserDetails;
import com.example.jobboard_final.entities.RequestRecruit;
import com.example.jobboard_final.entities.Status;
import com.example.jobboard_final.services.JobServices;
import com.example.jobboard_final.services.RequestRecruitService;
import com.example.jobboard_final.services.StatusService;
import com.example.jobboard_final.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                String message = "You have already apply,please wait to respone";
                return gson.toJson(message);
            }
            Job job = jobServices.getJobById(id);
            Status status = statusService.getById(3L);
            if (requestRecruitService.apply(job, ((MyUserDetails) principal).getUser().getUser(), status)) {
                String message = "Apply Success";
                return gson.toJson(message);
            }
        }
        if(principal instanceof User) {
            if (requestRecruitService.existByUserAndJob(((User) principal).getUsername(), id)) {
                String message = "You have already apply,please wait to respone";
                return gson.toJson(message);
            }
            Job job = jobServices.getJobById(id);
            Status status = statusService.getById(3L);
            if (requestRecruitService.apply(job,userService.findByIdsocial(((User) principal).getUsername()) , status)) {
                String message = "Apply Success";
                return gson.toJson(message);
            }
        }
        String message = "Something went wrong";
        return gson.toJson(message);
    }

    @ResponseBody
    @GetMapping("/deny")
    public String getDeny(@RequestParam("id") Long id){
        if(!requestRecruitService.existsById(id)){
            return "redirect:/404";
        }
        requestRecruitService.setRequestStatus(id,statusService.getById(2L));
        String message = "This request has been denied";
        Gson gson = new Gson();
        return gson.toJson(message);
    }

    @ResponseBody
    @GetMapping("/accept")
    public String getAccept(@RequestParam("id") Long id){
        if(!requestRecruitService.existsById(id)){
            return "redirect:/404";
        }
        requestRecruitService.setRequestStatus(id,statusService.getById(1L));
        String message = "This request has been accept";
        Gson gson = new Gson();
        return gson.toJson(message);
    }

}
