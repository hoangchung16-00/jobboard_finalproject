package com.example.jobboard_final.entities;

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
    private Long id;
    private String name;
    @OneToMany(mappedBy = "status",fetch = FetchType.LAZY)
    private List<RequestRecruit> requestRecruitList;

    public Status(String name, List<RequestRecruit> requestRecruitList) {
        name = name;
        this.requestRecruitList = requestRecruitList;
    }
}
