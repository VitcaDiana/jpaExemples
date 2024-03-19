package com.springapps.jpaexamples.movieapp;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private Long movieId;
    @Column
    private String name;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Character> characters;

    @ManyToOne
    @JoinColumn(name = "francise_id")
    private Francise francise;

    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Character> getCharacters() {
        if (characters == null){
            characters = new HashSet<>();
        }
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Francise getFrancise() {
        return francise;
    }

    public void setFrancise(Francise francise) {
        this.francise = francise;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
             //   ", characters=" + characters +
                ", francise=" + francise +
                '}';
    }
}
