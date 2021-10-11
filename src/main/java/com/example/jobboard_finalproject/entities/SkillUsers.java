package com.example.jobboard_finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skillUsers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillUsers {
    @Id
    private int Id;
    private String Name;
    private String Experience;
    @ManyToOne
    @JoinColumn(name = "UsersId")
    private Users user;

    public SkillUsers(String name, String experience, Users user) {
        Name = name;
        Experience = experience;
        this.user = user;
    }
}
