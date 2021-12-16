package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "jobtype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobType {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "jobType",fetch = FetchType.LAZY)
    private List<Job> jobList;

    public JobType(String name, List<Job> jobList) {
        name = name;
        this.jobList = jobList;
    }
}
