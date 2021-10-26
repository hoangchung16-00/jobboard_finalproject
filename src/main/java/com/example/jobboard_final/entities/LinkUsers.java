package com.example.jobboard_final.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "linkusers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkUsers {
    @Id
    private int id;
    private String link;
    @ManyToOne
    @JoinColumn(name = "linktypeid")
    private LinkType linkType;
    @ManyToOne
    @JoinColumn(name = "usersid")
    private Users user;

    public LinkUsers(String link, LinkType linkType, Users user) {
        this.link = link;
        this.linkType = linkType;
        this.user = user;
    }
}
