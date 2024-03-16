package com.springapps.jpaexamples.course_app;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "session",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    List<Attendance> attendances;

    @OneToMany(mappedBy = "session",cascade = {CascadeType.ALL},orphanRemoval = true)
    List<Subject> subject;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;



    public Session(){
    }

}
