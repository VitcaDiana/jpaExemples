package com.springapps.jpaexamples.manytomany_demo.v1;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Course() {
    }
}
