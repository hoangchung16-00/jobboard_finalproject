package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "benefit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Benefit {
    @Id
    private int id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "jobid")
    private Job job;

    public Benefit(String description, Job job) {
        this.description = description;
        this.job = job;
    }
}
