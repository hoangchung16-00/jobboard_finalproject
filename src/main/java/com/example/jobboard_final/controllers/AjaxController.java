package com.example.jobboard_final.controllers;

import com.example.jobboard_final.entities.Job;
import com.example.jobboard_final.entities.MyUserDetails;
import com.example.jobboard_final.entities.Status;
import com.example.jobboard_final.services.JobServices;
import com.example.jobboard_final.services.RequestRecruitService;
import com.example.jobboard_final.services.StatusService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @ResponseBody
    @GetMapping("/apply")
    public String getApply(@RequestParam("id") Long id){
        if(!jobServices.existsById(id)){
            return "redirect:/404";
        }
        Gson gson = new Gson();
        MyUserDetails principal =(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(requestRecruitService.existByUserAndJob(principal.getUser().getUser().getId(),id)){
            String message = "You have already apply,please wait to respone";
            return gson.toJson(message);
        }
        Job job = jobServices.getJobById(id);
        Status status = statusService.getById(3L);
        if(requestRecruitService.apply(job,principal.getUser().getUser(),status)){
            String message = "Apply Success";
            return gson.toJson(message);
        }
        String message = "Something went wrong";
        return gson.toJson(message);
    }
}
