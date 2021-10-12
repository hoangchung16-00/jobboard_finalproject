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
    private int Id;
    private String Description;
    @ManyToOne
    @JoinColumn(name = "JobId")
    private Job job;

    public Benefit(String description, Job job) {
        Description = description;
        this.job = job;
    }
}
