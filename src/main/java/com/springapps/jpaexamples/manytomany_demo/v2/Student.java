package com.springapps.jpaexamples.manytomany_demo.v2;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> courseRegistrations;


    public Student() {
    }
}
