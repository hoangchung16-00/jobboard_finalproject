package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Account;
import com.example.jobboard_final.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Transactional
    public List<Account> getAccounts(){
        return accountRepository.getAccounts();
    }
    @Transactional
    public Account findByUsername(String username){
        return accountRepository.findByUsername(username);
    }
    @Transactional
    public boolean existsByUsername(String username){
        return accountRepository.existsByUsername(username);
    }
}
