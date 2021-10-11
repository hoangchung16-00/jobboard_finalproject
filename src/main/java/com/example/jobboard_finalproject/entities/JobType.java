package com.example.jobboard_finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "jobType")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobType {
    @Id
    private int Id;
    private String Name;
    @OneToMany(mappedBy = "jobType",fetch = FetchType.LAZY)
    private List<Job> jobList;

    public JobType(String name, List<Job> jobList) {
        Name = name;
        this.jobList = jobList;
    }
}
