package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "linkUsers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkUsers {
    @Id
    private int Id;
    private String Link;
    @ManyToOne
    @JoinColumn(name = "LinkTypeId")
    private LinkType linkType;
    @ManyToOne
    @JoinColumn(name = "UsersId")
    private Users user;

    public LinkUsers(String link, LinkType linkType, Users user) {
        Link = link;
        this.linkType = linkType;
        this.user = user;
    }
}
