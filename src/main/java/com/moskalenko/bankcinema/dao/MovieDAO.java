package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieDAO extends CrudRepository<Movie, Long> {
    Optional<Movie> getMovieById(Long id);

}
