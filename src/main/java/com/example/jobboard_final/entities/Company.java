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
    private int Id;
    private String Name;
    private String ShortDescription;
    private String Address;
    private String Website;
    private int FoundationYear;
    private int Employee;
    private String Description;
    private String Email;
    private String PhoneNumber;
    @OneToOne
    @JoinColumn(name = "AccountId")
    private Account account;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Job> jobList;

    public Company(String name, String shortDescription, String address, String website, int foundationYear, int employee, String description, String email, String phoneNumber, Account account, List<Job> jobList) {
        Name = name;
        ShortDescription = shortDescription;
        Address = address;
        Website = website;
        FoundationYear = foundationYear;
        Employee = employee;
        Description = description;
        Email = email;
        PhoneNumber = phoneNumber;
        this.account = account;
        this.jobList = jobList;
    }
}
