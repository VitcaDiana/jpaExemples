package com.springapps.jpaexamples.movieapp;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "francise")
public class Francise {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "francise")
    private List<Movie> movies;

    public Francise(String name) {
        this.name = name;
    }

    public Francise() {
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Francise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
