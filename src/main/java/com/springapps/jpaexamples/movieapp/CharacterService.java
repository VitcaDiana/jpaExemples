package com.springapps.jpaexamples.movieapp;

import com.springapps.jpaexamples.twitterapp.Tweet;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CharacterService {
    CharacterRepository characterRepository;
    MovieRepository movieRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }

    @Transactional
    public Movie addCharacterToMovie(Long movieId, Character character) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new EntityNotFoundException("ID not found"));
        movie.getCharacters().add(character);
        character.getMovies().add(movie);
        characterRepository.save(character);
        return movieRepository.save(movie);


    }

    public List<Character> findAllCharactersFromMovie(Movie movie) {
        return characterRepository.findAllByMoviesContaining(movie);
    }
}
