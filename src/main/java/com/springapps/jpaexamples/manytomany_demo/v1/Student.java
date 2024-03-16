package com.springapps.jpaexamples.manytomany_demo.v1;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "course_student",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    public Student() {
    }
}
