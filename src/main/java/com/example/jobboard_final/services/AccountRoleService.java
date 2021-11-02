package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.AccountRole;
import com.example.jobboard_final.repositories.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Transactional
    public AccountRole getById(Long id){
        return accountRoleRepository.getById(id);
    }
}
