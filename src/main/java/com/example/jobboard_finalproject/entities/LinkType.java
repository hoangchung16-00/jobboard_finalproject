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
public class LinkType {
    @Id
    private int Id;
    private String Name;
    @OneToMany(mappedBy = "linkType",fetch = FetchType.LAZY)
    private List<LinkUsers>  linkUsersList;

    public LinkType(String name, List<LinkUsers> linkUsersList) {
        Name = name;
        this.linkUsersList = linkUsersList;
    }

}
