package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private int Id;
    private String Name;
    private String PhoneNumber;
    private String Email;
    private String Address;
    private Date DOB;
    private String Education;
    private String Descroiption;
    private String Hobby;
    @OneToOne
    @JoinColumn(name = "AccountId")
    private Account account;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<SkillUsers> skillUsersList;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<LinkUsers> linkUsersList;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<RequestRecruit> requestRecruitList;

    public Users(String name, String phoneNumber, String email, String address, Date DOB, String education, String descroiption, String hobby, Account account, List<SkillUsers> skillUsersList, List<LinkUsers> linkUsersList, List<RequestRecruit> requestRecruitList) {
        Name = name;
        PhoneNumber = phoneNumber;
        Email = email;
        Address = address;
        this.DOB = DOB;
        Education = education;
        Descroiption = descroiption;
        Hobby = hobby;
        this.account = account;
        this.skillUsersList = skillUsersList;
        this.linkUsersList = linkUsersList;
        this.requestRecruitList = requestRecruitList;
    }
}
