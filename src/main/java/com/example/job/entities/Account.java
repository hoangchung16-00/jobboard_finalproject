package com.example.job.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enable;
    private String verificationcode;
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

    public Account(String username, String password, AccountRole accountrole, Users user) {
        this.username = username;
        this.password = password;
        this.accountrole = accountrole;
        this.user = user;
    }

    public Account(String username, boolean enable, AccountRole accountrole, Users user) {
        this.username = username;
        this.enable = enable;
        this.accountrole = accountrole;
        this.user = user;
    }
}
