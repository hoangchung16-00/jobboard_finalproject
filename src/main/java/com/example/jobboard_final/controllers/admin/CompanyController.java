package com.example.jobboard_final.controllers.admin;

import com.example.jobboard_final.controllers.BaseController;
import com.example.jobboard_final.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController extends BaseController {
    @Autowired
    private CompanyService companyService;
    public static final int PAGE_SIZE = 10;
    @GetMapping("/admin/company")
    public String getCompanyList(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        int totalPage = (companyService.getTotalCompany()+PAGE_SIZE-1)/PAGE_SIZE;
        if(page> totalPage){
            return "redirect:/404";
        }
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currentPage",page);
        model.addAttribute("companies",companyService.getCompanies(pageable));
        model.addAttribute("total",companyService.getTotalCompany());
        model.addAttribute("active","company");
        return "admin/company";
    }

}
