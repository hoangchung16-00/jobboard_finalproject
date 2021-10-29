package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "requestrecruit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRecruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "jobid")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "usersid")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "statusid")
    private Status status;

    public RequestRecruit(Job job, Users user, Status status) {
        this.job = job;
        this.user = user;
        this.status = status;
    }
}
