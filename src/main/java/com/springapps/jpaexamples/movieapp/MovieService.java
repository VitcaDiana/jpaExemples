package com.springapps.jpaexamples.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    MovieRepository movieRepository;
@Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Transactional
    public Movie addMovie(Movie movie){
    return movieRepository.save(movie);
    }
}
