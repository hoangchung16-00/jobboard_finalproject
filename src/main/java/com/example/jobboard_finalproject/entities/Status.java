package com.example.jobboard_finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    @OneToMany(mappedBy = "status",fetch = FetchType.LAZY)
    private List<RequestRecruit> requestRecruitList;

    public Status(String name, List<RequestRecruit> requestRecruitList) {
        Name = name;
        this.requestRecruitList = requestRecruitList;
    }
}
