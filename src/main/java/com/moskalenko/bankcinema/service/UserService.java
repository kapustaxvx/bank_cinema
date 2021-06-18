package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    
    public User addUser(UserDTO userData) {
        return null;
    }

    public void addToUserMoviesList(Long userId, Long movieId) {
    }

    public Collection<User> getAllUsers() {
        return null;
    }

    public void deleteFromUserMoviesList(Long userId, Long movieId) {
    }

    public void rateTheMovie(Long userId, Long movieId, Integer rate) {
    }

    public void updateMovieViewInfo(Long userId, Long movieId) {
    }

    public Collection<Movie> getAllMoviesFromUserMoviesList(Long userId) {
        return null;
    }

    public Collection<Movie> getAllUnseenMoviesFromUserMoviesList(Long userId) {
        return null;
    }

    public User getUserById(Long userId) {
        return null;
    }
}
