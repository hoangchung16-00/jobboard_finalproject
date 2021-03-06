package com.example.job.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skilljob")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "leveltypeid")
    private LevelType levelType;
    @ManyToOne
    @JoinColumn(name = "jobid")
    private Job job;

    public SkillJob(String name, LevelType levelType, Job job) {
        this.name = name;
        this.levelType = levelType;
        this.job = job;
    }
}
