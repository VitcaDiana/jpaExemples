package com.springapps.jpaexamples.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    CharacterService characterService;
    MovieService movieService;
@Autowired
    public Runner(CharacterService characterService, MovieService movieService) {
        this.characterService = characterService;
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
    Character character = new Character("Tom Hanks");
    Movie movie = new Movie("Saving Private Ryan");
    Movie savedMovie = movieService.addMovie(movie);
    characterService.addCharacterToMovie(savedMovie.getMovieId(),character);
        System.out.println(characterService.findAllCharactersFromMovie(movie));

    }
}
