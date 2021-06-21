package com.moskalenko.bankcinema.api.client;

import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.User;

import java.util.Collection;

public interface UserClient {
    User addUser(UserDTO userData);

    User getUserById(Long userId);

    Collection<User> getAllUsers();

    void addToUserMoviesList(Long userId, Long movieId);

    void deleteFromUserMoviesList(Long userId, Long movieId);

    void rateTheMovie(Long userId, Long movieId, Integer rate);

    void updateMovieViewInfo(Long userId, Long movieId);

    Collection<Movie> getAllMoviesFromUserMoviesList(Long userId);

    Collection<Movie> getAllUnseenMoviesFromUserMoviesList(Long userId);
}

