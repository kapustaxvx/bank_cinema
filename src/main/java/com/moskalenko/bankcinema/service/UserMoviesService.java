package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.User;
import com.moskalenko.bankcinema.api.entity.UserMovies;
import com.moskalenko.bankcinema.dao.UserMoviesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserMoviesService {

    private final static Logger log = LoggerFactory.getLogger(UserMoviesService.class);
    private final UserMoviesDAO userMoviesDAO;
    private final UserService userService;
    private final MovieService movieService;

    public UserMoviesService(UserMoviesDAO userMoviesDAO, UserService userService,
                             MovieService movieService) {
        this.userMoviesDAO = userMoviesDAO;
        this.userService = userService;
        this.movieService = movieService;
    }

    @Transactional
    public void addToUserMoviesList(Long userId, Long movieId) {
        final User user = userService.getUserById(userId);
        final Movie movie = movieService.getMovieById(movieId);
        final UserMovies userMovies = new UserMovies(user, movie);

        userMoviesDAO.save(userMovies);
        log.info("[{}] User add [{}] movie to wishlist", userId, movieId);
    }


    @Transactional
    public void deleteFromUserMoviesList(Long userId, Long movieId) {
        final UserMovies userMovies = validUserMovies(userId, movieId);
        userMoviesDAO.deleteUserMoviesByUserAndMovie(userMovies.getUser(), userMovies.getMovie());
        log.info("[{}] User delete [{}] movie from wishlist", userId, movieId);
    }

    @Transactional
    public void rateTheMovie(Long userId, Long movieId, Integer rate) {
        final UserMovies userMovies = validUserMovies(userId, movieId);
        if (rate < 0 || rate > 10) {
            log.info("Your rate must be from 0 ti 10");
            throw new RuntimeException("Rate is invalid");
        }
        userMovies.setRate(rate);
        userMoviesDAO.save(userMovies);
        final Double rating = getMovieRating(movieId);
        movieService.updateMovieRating(movieId, rating);
        log.info("[{}] User rate by [{}] movie [{}]", userId, rate, movieId);
    }

    @Transactional
    public void updateMovieViewInfoToWatched(Long userId, Long movieId) {
        final UserMovies userMovies = validUserMovies(userId, movieId);
        userMovies.setWatched(true);
        userMoviesDAO.save(userMovies);
        log.info("[{}] User update [{}] movie as watched", userId, movieId);
    }

    public Collection<Movie> getAllMoviesFromUserMoviesList(Long userId) {
        final User user = userService.getUserById(userId);
        final Collection<UserMovies> userMovies = userMoviesDAO.findAllByUser(user);
        if (userMovies.isEmpty()) {
            log.info("[{}] User's movies list is empty", userId);
            throw new RuntimeException("List is empty");
        }
        Collection<Movie> movies = userMovies.stream()
                .filter(um-> um.getUser().getId().equals(userId))
                .map(UserMovies::getMovie)
                .collect(Collectors.toSet());
        log.info("[{}] User's all movies from list", userId);
        return movies;
    }

    public Collection<Movie> getAllUnseenMoviesFromUserMoviesList(Long userId) {
        final User user = userService.getUserById(userId);
        final Collection<UserMovies> unseenUserMovies = userMoviesDAO.findAllByUserAndIsWatched(user, false);
        if (unseenUserMovies.isEmpty()) {
            log.info("[{}] User's unseen movies list is empty", userId);
            throw new RuntimeException("List is empty");
        }

        Collection<Movie> movies = unseenUserMovies.stream()
                .filter(um-> um.getUser().getId().equals(userId))
                .filter(um -> um.getWatched().equals(false))
                .map(UserMovies::getMovie)
                .collect(Collectors.toSet());
        log.info("[{}] User's unseen movies from list", userId);
        return movies;
    }

    private UserMovies validUserMovies(Long userId, Long movieId) {
        final User user = userService.getUserById(userId);
        final Movie movie = movieService.getMovieById(movieId);
        final UserMovies userMovies = userMoviesDAO.getByUserAndAndMovie(user, movie).orElse(null);
        if (userMovies == null) {
            log.info("[{}] User has not [{}] movie in the list", userId, movieId);
            throw new RuntimeException("User has not such movie in the list");
        }
        return userMovies;
    }

    private Double getMovieRating(Long movieId) {
        final Movie movie = movieService.getMovieById(movieId);
        final Collection<UserMovies> movies = userMoviesDAO.findAllByMovieAndRateNotNull(movie);
        if (movies.isEmpty()) {
            log.info("[{}] Movie have not rate", movieId);
            throw new RuntimeException("List is empty");
        }
        final Double rating = movies.stream()
                .mapToDouble(UserMovies::getRate)
                .average()
                .getAsDouble();
        log.info("[{}] Movie's rating is [{}]", movieId, rating);
        return rating;
    }
}
