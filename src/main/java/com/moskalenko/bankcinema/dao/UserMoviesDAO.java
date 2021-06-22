package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.User;
import com.moskalenko.bankcinema.api.entity.UserMovies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserMoviesDAO extends CrudRepository<UserMovies, Long> {
    Collection<UserMovies> findAllByUserAndIsWatched(User user, Boolean watched);
    void deleteUserMoviesByUserAndMovie(User user, Movie movie);
    Optional<UserMovies> getByUserAndAndMovie(User user, Movie movie);
    Collection<UserMovies> findAllByUser(User user);
    Collection<UserMovies> findAllByMovieAndRateNotNull(Movie movie);

}
