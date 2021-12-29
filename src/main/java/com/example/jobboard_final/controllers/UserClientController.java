package com.example.jobboard_final.controllers;

import com.example.jobboard_final.entities.*;
import com.example.jobboard_final.forms.EditProfileForm;
import com.example.jobboard_final.services.RequestRecruitService;
import com.example.jobboard_final.services.SkillUsersService;
import com.example.jobboard_final.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserClientController extends BaseController{
    public static final int PAGE_SIZE = 10;
    @Autowired
    private UserService userService;

    @Autowired
    private SkillUsersService skillUsersService;

    @Autowired
    private RequestRecruitService requestRecruitService;

    @GetMapping("/profile/{id}")
    public String getProfile(Model model, @PathVariable("id") Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof MyUserDetails){
            if(((MyUserDetails) principal).getUser().getAccountrole().getName().equalsIgnoreCase("USER")){
                if(((MyUserDetails) principal).getUser().getUser().getId()!=id){
                    return "404";
                }
            }
        } else {
            if (principal instanceof UserDetails) {
                if (userService.findByIdsocial(((UserDetails) principal).getUsername()).getId() != id) {
                    return "404";
                }
            }
        }
        if(!userService.existsById(id)){
            return "404";
        }
        model.addAttribute("user",userService.findUsersById(id));
        return "profile";
    }

    @GetMapping("/editProfile")
    public String getEditProfile(Model model){
        Users user = ((Account) model.getAttribute("account")).getUser();
        EditProfileForm editProfileForm = new EditProfileForm();
        editProfileForm = userService.getEditProfileForm(user,skillUsersService.findByUsersId(user.getId()));
        model.addAttribute("editProfileForm",editProfileForm);
        return "editProfile";
    }

    @PostMapping("/editProfile")
    public String postEditProfile(@RequestParam("imageUser") MultipartFile image, @Valid @ModelAttribute("editProfileForm") EditProfileForm editProfileForm, BindingResult bindingResult, Model model) throws ParseException, IOException {
        if(!image.isEmpty()){
            String fileName =editProfileForm.getId().toString()+"user" + image.getOriginalFilename();
            String oldFileName = editProfileForm.getImage();
            if (!fileName.contains(".jpg") && !fileName.contains(".png")) {
                bindingResult.rejectValue("image","error.image","File invalid");
            }
            else {
                if(!oldFileName.equals("user.png")){
                    Path oldImagePath = Paths.get("src/main/resources/static/image/" + oldFileName);
                    Files.delete(oldImagePath);
                }
                editProfileForm.setImage(fileName);
                Path imagePath = Paths.get("src/main/resources/static/image/" + fileName);
                Files.write(imagePath, image.getBytes());
            }
        }
        Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(editProfileForm.getDob());
        if(date.after(new Date()) || date.getYear() < 0){
            bindingResult.rejectValue("dob","error.profile","Ngày sinh không hợp lệ");
        }
        if(bindingResult.hasErrors()){
            return "editProfile";
        }
        userService.editUser(editProfileForm);
        skillUsersService.editListSkill(editProfileForm.getSkillIdList(),editProfileForm.getSkillNameList(),editProfileForm.getSkillExperienceList());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = ((MyUserDetails) principal).getUser();
        return "redirect:/profile/" + account.getUser().getId();
    }

    @GetMapping("/addSkill")
    public String getAddSkill(Model model){
        model.addAttribute("skillUser",new SkillUsers());
        return "addSkill";
    }

    @PostMapping("/addSkill")
    public String postAddSkill(@Valid @ModelAttribute("skillUser") SkillUsers skillUsers, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addSkill";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = new Users();
        if(principal instanceof MyUserDetails){
             user = ((MyUserDetails) principal).getUser().getUser();
        } else {
            if(principal instanceof UserDetails) {
                 user = userService.findByIdsocial(((UserDetails) principal).getUsername());
            }
        }
        skillUsers.setUser(user);
        skillUsersService.addSkill(skillUsers);
        return "redirect:/profile/"+user.getId();
    }

    @GetMapping("/removeSkill/{id}")
    public String getRemoveSkill(@PathVariable("id") Long id){
        if(!skillUsersService.existById(id)){
            return "redirect:/404";
        }
        skillUsersService.removeSkill(skillUsersService.getById(id));
        return "redirect:/editProfile";
    }
    @GetMapping("/applyList")
    public String getApplyList(Model model,@RequestParam(value = "page",defaultValue = "1") int page){
        Pageable pageable = PageRequest.of(page-1,PAGE_SIZE);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = new Users();
        if(principal instanceof MyUserDetails){
            user = ((MyUserDetails) principal).getUser().getUser();
        } else {
            if(principal instanceof UserDetails) {
                user = userService.findByIdsocial(((UserDetails) principal).getUsername());
            }
        }
        model.addAttribute("applyList",requestRecruitService.findByUser(user,pageable));
        model.addAttribute("totalPage",(requestRecruitService.getTotalRequestByUser(user)+PAGE_SIZE-1)/PAGE_SIZE);
        model.addAttribute("currentPage",page);
        return "applyList";
    }
}
