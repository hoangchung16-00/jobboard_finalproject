package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "leveltype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "levelType",fetch = FetchType.LAZY)
    private List<SkillJob> skillJobList;

    public LevelType(String name, List<SkillJob> skillJobList) {
        name = name;
        this.skillJobList = skillJobList;
    }
}
