package com.example.jobboard_final.controllers.admin;

import com.example.jobboard_final.controllers.BaseController;
import com.example.jobboard_final.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAdminController extends BaseController {
    @Autowired
    private UserService userService;
    public static final int PAGE_SIZE = 10;
    @GetMapping("/admin/user")
    public String getUserList(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        int totalPage = (userService.getTotalUser()+PAGE_SIZE-1)/PAGE_SIZE;
        if(page> totalPage){
            return "redirect:/404";
        }
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currentPage",page);
        model.addAttribute("users",userService.getUsers(pageable));
        model.addAttribute("total",userService.getTotalUser());
        model.addAttribute("active","user");
        return "admin/user";
    }
}
