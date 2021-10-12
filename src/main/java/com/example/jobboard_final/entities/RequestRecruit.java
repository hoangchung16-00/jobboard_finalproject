package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "requestRecruit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRecruit {
    @Id
    private int Id;
    @ManyToOne
    @JoinColumn(name = "JobId")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "UsersId")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "StatusId")
    private Status status;

    public RequestRecruit(Job job, Users user, Status status) {
        this.job = job;
        this.user = user;
        this.status = status;
    }
}
