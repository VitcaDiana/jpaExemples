package com.springapps.jpaexamples.course_app;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL,orphanRemoval = true)
    List<User> participants;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }


}
