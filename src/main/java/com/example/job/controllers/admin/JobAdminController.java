package com.example.job.controllers.admin;

import com.example.job.controllers.BaseController;
import com.example.job.services.CompanyService;
import com.example.job.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobAdminController extends BaseController {
    @Autowired
    private JobServices jobServices;

    @Autowired
    private CompanyService companyService;

    public static final int PAGE_SIZE = 10;

    @GetMapping("/admin/job/{id}")
    public String getListJobByCompany(@PathVariable("id") Long id, Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        int totalPage = (jobServices.getTotalJobByCompany(id)+PAGE_SIZE-1)/PAGE_SIZE;
        totalPage = totalPage == 0 ? 1 : totalPage;
        if(page > totalPage || page < 1){
            return "redirect:/404";
        }
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("jobs",jobServices.getJobsByCompany(id,pageable));
        model.addAttribute("active","job");
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("total",jobServices.getTotalJobByCompany(id));
        return "admin/job";
    }

    @GetMapping("/admin/job")
    public String getListJob(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        int totalPage = (jobServices.getTotalJob()+PAGE_SIZE-1)/PAGE_SIZE;
        totalPage = totalPage == 0 ? 1 : totalPage;
        if(page > totalPage || page < 1){
            return "redirect:/404";
        }
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("jobs",jobServices.getJobs(pageable));
        model.addAttribute("active","job");
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("total",jobServices.getTotalJob());
        return "admin/job";
    }

}
