package com.springapps.jpaexamples.course_app;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    private String street;

    private int nrSrreet;

    @OneToMany(mappedBy = "location")
    List<Session> sessions;

    public Location(){}

    public Location(String name, String street, int nrSrreet) {
        this.name = name;
        this.street = street;
        this.nrSrreet = nrSrreet;
    }
}
