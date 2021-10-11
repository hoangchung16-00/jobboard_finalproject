package com.example.jobboard_finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "levelType")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelType {
    @Id
    private int Id;
    private String Name;
    @OneToMany(mappedBy = "levelType",fetch = FetchType.LAZY)
    private List<SkillJob> skillJobList;

    public LevelType(String name, List<SkillJob> skillJobList) {
        Name = name;
        this.skillJobList = skillJobList;
    }
}
