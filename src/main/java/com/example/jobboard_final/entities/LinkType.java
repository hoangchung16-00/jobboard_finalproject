package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "linktype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkType {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "linkType",fetch = FetchType.LAZY)
    private List<LinkUsers>  linkUsersList;

    public LinkType(String name, List<LinkUsers> linkUsersList) {
        name = name;
        this.linkUsersList = linkUsersList;
    }

}
