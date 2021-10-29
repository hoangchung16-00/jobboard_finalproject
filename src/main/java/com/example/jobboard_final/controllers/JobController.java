package com.example.jobboard_final.controllers;

import com.example.jobboard_final.entities.Job;
import com.example.jobboard_final.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController extends BaseController{
    public static final int PAGE_SIZE = 10;
    @Autowired
    private JobServices jobServices;
    @GetMapping("/")
    public String getHome(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("jobs",jobServices.getJobs(pageable));
        model.addAttribute("totalPage",(jobServices.getTotalJob()+PAGE_SIZE-1)/PAGE_SIZE);
        model.addAttribute("currentPage",page);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "home";
    }
    @GetMapping("/jobdetail")
    public String getJobDetail(Model model,@RequestParam(value = "id") Long id){
        if(!jobServices.existsById(id)){
            return "redirect:/404";
        }
        Job job = jobServices.getJobById(id);

        model.addAttribute("job",job);

        return "jobdetail";
    }
}
