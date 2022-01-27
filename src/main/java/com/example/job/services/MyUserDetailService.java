package com.example.job.services;

import com.example.job.entities.Account;
import com.example.job.entities.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    private Map<String, User> roles = new HashMap<>();

    @PostConstruct
    public void init() {
        String role;
        for (Account account : accountService.getAccounts()){
            if(account.getAccountrole().getName().equals("Admin"))
                role = "ADMIN";
            else if (account.getAccountrole().getName().equals("User"))
                role="USER";
            else
                role="COMPANY";
            roles.put(account.getUsername(), new User(account.getUsername(), "{noop}"+account.getPassword(), getAuthority(role)));
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        if (!accountService.existsByUsername(username)) {
            throw new UsernameNotFoundException("Could not find user");
        }
        Account account = accountService.findByUsername(username);
        return new MyUserDetails(account);
    }
    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
