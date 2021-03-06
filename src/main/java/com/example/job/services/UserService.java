package com.example.job.services;

import com.example.job.entities.Account;
import com.example.job.entities.MyUserDetails;
import com.example.job.entities.SkillUsers;
import com.example.job.entities.Users;
import com.example.job.forms.EditProfileForm;
import com.example.job.forms.RegisterForm;
import com.example.job.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<Users> getUsers(Pageable pageable){
        List<Users> users = userRepository.getUsers(pageable);
        return users;
    }

    @Transactional
    public int getTotalUser(){
        return userRepository.getTotalUser();
    }

    @Transactional
    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    @Transactional
    public Users findUsersById(Long id){
        Users user = userRepository.findUsersById(id);
        user.getSkillUsersList().size();
        user.getLinkUsersList().size();
        return user;
    }

    @Transactional
    public List<Users> getUsers(){
        return userRepository.getUsers();
    }

    @Transactional
    public boolean existsByIdsocial(String id){
        return userRepository.existsByIdsocial(id);
    }

    @Transactional
    public Users createUser(String name,String image,String idsocial){
        return userRepository.save(new Users(name,image,idsocial));
    }

    @Transactional
    public Users findByIdsocial(String id){
        return userRepository.findByIdsocial(id);
    }

    @Transactional
    public void register(RegisterForm registerForm, Account account, String siteURL) throws UnsupportedEncodingException, MessagingException {
        Users user = new Users();
        user.setEmail(registerForm.getEmail());
        user.setAccount(account);
        user.setName(registerForm.getName());
        user.setImage("user.png");
        userRepository.save(user);
        emailService.sendUserVerificationEmail(user,siteURL);
    }


    @Transactional
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public EditProfileForm getEditProfileForm(Users user, List<SkillUsers> skillUsers){
        String s = "";
        if(user.getDob() != null) {
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            s = formatter.format(user.getDob());
        }
        List<String> names = new ArrayList<>();
        List<String> experiences = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        for (SkillUsers skill : skillUsers) {
            names.add(skill.getName());
            experiences.add(skill.getExperience());
            ids.add(skill.getId());
        }
        EditProfileForm editProfileForm = new EditProfileForm(user.getId(),user.getName(),user.getPhonenumber(),user.getEmail(),user.getAddress(),s,user.getEducation(),user.getDescription(),user.getHobby(),user.getGender(),user.getImage(),names,experiences,ids);
        return editProfileForm;
    }

    @Transactional
    public void editUser(EditProfileForm editProfileForm) throws ParseException {
        Users user = findUsersById(editProfileForm.getId());
        user.setImage(editProfileForm.getImage());
        user.setName(editProfileForm.getName());
        user.setEmail(editProfileForm.getEmail());
        user.setAddress(editProfileForm.getAddress());
        user.setDescription(editProfileForm.getDescription());
        user.setGender(editProfileForm.getGender());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        user.setDob(dateFormat.parse(editProfileForm.getDob()));
        user.setEducation(editProfileForm.getEducation());
        user.setHobby(editProfileForm.getHobby());
        user.setPhonenumber(editProfileForm.getPhonenumber());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof MyUserDetails) {
            ((MyUserDetails) principal).getUser().setUser(user);
        }
        userRepository.save(user);
    }
}
