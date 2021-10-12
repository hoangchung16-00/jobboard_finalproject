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
    private int Id;
    private String Username;
    private String Password;
    @ManyToOne
    @JoinColumn(name = "AccountRoleId")
    private AccountRole accountRole;
    @OneToOne(mappedBy = "account")
    private Users user;
    @OneToOne(mappedBy = "account")
    private Company company;

    public Account(String username, String password, AccountRole accountRole, Users user, Company company) {
        Username = username;
        Password = password;
        this.accountRole = accountRole;
        this.user = user;
        this.company = company;
    }
}
