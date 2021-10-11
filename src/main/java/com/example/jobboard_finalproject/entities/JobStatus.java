package com.example.jobboard_finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "linkType")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobStatus {
    @Id
    private int Id;
    private String Name;
    @OneToMany(mappedBy = "jobStatus",fetch = FetchType.LAZY)
    private List<Job> jobList;

    public JobStatus(String name, List<Job> jobList) {
        Name = name;
        this.jobList = jobList;
    }
}
