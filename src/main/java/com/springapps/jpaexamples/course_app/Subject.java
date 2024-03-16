package com.springapps.jpaexamples.course_app;

import jakarta.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public Subject(){}

    public Subject(String title) {
        this.title = title;
    }
}
