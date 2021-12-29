package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "skillusers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên kỹ năng không được để trống")
    private String name;
    private String experience;
    @ManyToOne
    @JoinColumn(name = "usersid")
    private Users user;

    public SkillUsers(String name, String experience, Users user) {
        this.name = name;
        this.experience = experience;
        this.user = user;
    }
}
