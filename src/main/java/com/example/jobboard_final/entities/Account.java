package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "accountroleid")
    private AccountRole accountrole;
    @OneToOne(mappedBy = "account")
    private Users user;
    @OneToOne(mappedBy = "account")
    private Company company;

    public Account(String username, String password, AccountRole accountrole, Users user, Company company) {
        this.username = username;
        this.password = password;
        this.accountrole = accountrole;
        this.user = user;
        this.company = company;
    }
}
