package com.springapps.jpaexamples.manytomany_demo.v2;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
    @OneToMany(mappedBy = "course")
    private Set<CourseRegistration> courseRegistrations;

    public Course() {
    }
}
