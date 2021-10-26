package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "jobstatus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobStatus {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "jobStatus",fetch = FetchType.LAZY)
    private List<Job> jobList;

    public JobStatus(String name, List<Job> jobList) {
        name = name;
        this.jobList = jobList;
    }
}
