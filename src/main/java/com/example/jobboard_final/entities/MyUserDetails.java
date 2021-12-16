package com.example.jobboard_final.entities;

import com.example.jobboard_final.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private Account account;


    public MyUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role;
        if(account.getAccountrole().getName().equals("Admin"))
            role = "ADMIN";
        else if (account.getAccountrole().getName().equals("User"))
            role="USER";
        else
            role="COMPANY";
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account.isEnable();
    }

    public Account getUser() {
        return account;
    }

    public void setUser(Account account) {
        this.account = account;
    }
}
