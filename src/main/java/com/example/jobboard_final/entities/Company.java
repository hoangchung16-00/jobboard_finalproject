package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    private int id;
    private String name;
    private String shortdescription;
    private String address;
    private String website;
    private int foundationyear;
    private int employee;
    private String description;
    private String email;
    private String phonenumber;
    private String image;
    @OneToOne
    @JoinColumn(name = "accountid")
    private Account account;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Job> jobList;

    public Company(String name, String shortdescription, String address, String website, int foundationyear, int employee, String description, String email, String phonenumber, String image, Account account, List<Job> jobList) {
        this.name = name;
        this.shortdescription = shortdescription;
        this.address = address;
        this.website = website;
        this.foundationyear = foundationyear;
        this.employee = employee;
        this.description = description;
        this.email = email;
        this.phonenumber = phonenumber;
        this.image = image;
        this.account = account;
        this.jobList = jobList;
    }
}
