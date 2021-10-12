package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accountRole")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRole {
    @Id
    private int Id;
    private String Name;
    @OneToMany(mappedBy = "accountRole",fetch = FetchType.LAZY)
    private List<Account> accountList;

    public AccountRole(String name, List<Account> accountList) {
        Name = name;
        this.accountList = accountList;
    }
}
