package com.springapps.jpaexamples.manytomany_demo.v2;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class CourseRegistration {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column
    private LocalDate registered;
}
