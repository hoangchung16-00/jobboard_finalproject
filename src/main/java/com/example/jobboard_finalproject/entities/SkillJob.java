package com.example.jobboard_finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skillJob")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillJob {
    @Id
    private int Id;
    private String Name;
    @ManyToOne
    @JoinColumn(name = "LevelTypeId")
    private LevelType levelType;
    @ManyToOne
    @JoinColumn(name = "JobId")
    private Job job;

    public SkillJob(String name, LevelType levelType, Job job) {
        Name = name;
        this.levelType = levelType;
        this.job = job;
    }
}