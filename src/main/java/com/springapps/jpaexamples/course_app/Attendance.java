package com.springapps.jpaexamples.course_app;

import jakarta.persistence.*;

@Entity
public class Attendance {
    @Id
    @GeneratedValue
    private Long id;

    private boolean attending;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
