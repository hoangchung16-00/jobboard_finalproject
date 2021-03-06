package com.example.job.entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phonenumber;
    private String email;
    private String address;
    private Date dob;
    private String education;
    private String description;
    private String hobby;
    private String gender;
    private String image;
    private String idsocial;
    @OneToOne
    @JoinColumn(name = "accountid")
    private Account account;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<SkillUsers> skillUsersList;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<LinkUsers> linkUsersList;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<RequestRecruit> requestRecruitList;

    public Users(String name, String phonenumber, String email, String address, Date dob, String education, String description, String hobby, String gender, String image, Account account, List<SkillUsers> skillUsersList, List<LinkUsers> linkUsersList, List<RequestRecruit> requestRecruitList) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.education = education;
        this.description = description;
        this.hobby = hobby;
        this.gender = gender;
        this.image = image;
        this.account = account;
        this.skillUsersList = skillUsersList;
        this.linkUsersList = linkUsersList;
        this.requestRecruitList = requestRecruitList;
    }

    public Users(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Users(String name, String image, String idsocial) {
        this.name = name;
        this.image = image;
        this.idsocial = idsocial;
    }
}
