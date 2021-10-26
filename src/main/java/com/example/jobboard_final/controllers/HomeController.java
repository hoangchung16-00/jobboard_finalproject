package com.example.jobboard_final.controllers;

import com.example.jobboard_final.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    public static final int PAGE_SIZE = 10;
    @Autowired
    private JobServices jobServices;
    @GetMapping("/home")
    public String getHome(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("jobs",jobServices.getJobs(pageable));
        model.addAttribute("totalPage",(jobServices.getTotalJob()+PAGE_SIZE-1)/PAGE_SIZE);
        model.addAttribute("currentPage",page);
        return "home";
    }
}
