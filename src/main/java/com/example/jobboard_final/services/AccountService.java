package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Account;
import com.example.jobboard_final.entities.AccountRole;
import com.example.jobboard_final.entities.Users;
import com.example.jobboard_final.forms.RegisterForm;
import com.example.jobboard_final.repositories.AccountRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
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
    @Transactional
    public String createAccount(String username, String password, AccountRole accountRole, Users user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        Account account = new Account(username+user.getId(),encodedPassword,accountRole,user);
        accountRepository.save(account);
        return account.getUsername();
    }
    @Transactional
    public Account registerUser(RegisterForm registerForm,AccountRole accountRole){
        Account account = new Account();
        account.setEnable(false);
        String randomCode = RandomString.make(64);
        account.setVerificationcode(randomCode);
        account.setUsername(registerForm.getUsername());
        String encodePassword = bCryptPasswordEncoder.encode(registerForm.getPassword());
        account.setPassword(encodePassword);
        account.setAccountrole(accountRole);
        return accountRepository.save(account);
    }

    @Transactional
    public boolean existsByVerificationcode(String code){
        return accountRepository.existsByVerificationcode(code);
    }

    @Transactional
    public Account findByVerificationcode(String code){
        return accountRepository.findByVerificationcode(code);
    }

    @Transactional
    public void verify(Account account){
        account.setEnable(true);
        account.setVerificationcode(null);
        accountRepository.save(account);
    }
}
