package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accountrole")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "accountrole",fetch = FetchType.LAZY)
    private List<Account> accountlist;

    public AccountRole(String name, List<Account> accountlist) {
        this.name = name;
        this.accountlist = accountlist;
    }
}
