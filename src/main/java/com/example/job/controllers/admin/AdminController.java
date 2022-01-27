package com.example.job.controllers.admin;

import com.example.job.controllers.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController extends BaseController {
    @GetMapping("/admin/home")
    public String getAdminHome(){
        return "admin/home";
    }

}
