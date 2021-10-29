package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Users;
import com.example.jobboard_final.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserService {
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
}
