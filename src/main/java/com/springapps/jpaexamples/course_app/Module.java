package com.springapps.jpaexamples.course_app;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "module",cascade = {CascadeType.ALL},orphanRemoval = true)
    List<Session> sessions;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Module(){}

    public Module(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
