package com.example.job.services;

import com.example.job.entities.AccountRole;
import com.example.job.repositories.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Transactional
    public AccountRole getById(Long id){
        return accountRoleRepository.getById(id);
    }
    @Transactional
    public AccountRole getByName(String name){
        return accountRoleRepository.getByName(name);
    }

    @Transactional
    public List<AccountRole> findAll(){
        return accountRoleRepository.findAll();
    }
}
