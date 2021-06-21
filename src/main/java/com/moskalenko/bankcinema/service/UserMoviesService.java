package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.UserMovies;
import com.moskalenko.bankcinema.dao.UserMoviesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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
        checkUserAndMovieIsExist(userId, movieId);
        userMoviesDAO.addToUserMoviesList(userId, movieId);
        log.info("[{}] User add [{}] movie to wishlist", userId, movieId);
    }


    @Transactional
    public void deleteFromUserMoviesList(Long userId, Long movieId) {
        checkUserAndMovieIsExist(userId, movieId);
        userMoviesDAO.deleteFromUserMoviesList(userId, movieId);
        log.info("[{}] User delete [{}] movie from wishlist", userId, movieId);
    }

    @Transactional
    public void rateTheMovie(Long userId, Long movieId, Integer rate) {
        checkUserAndMovieIsExist(userId, movieId);
        if (rate < 0 && rate > 10) {
            log.info("Your rate must be from 0 ti 10");
            throw new RuntimeException("Rate is invalid");
        }
        userMoviesDAO.rateTheMovie(userId, movieId, rate);

        final Double rating = getMovieRating(movieId);
        movieService.updateMovieRating(movieId, rating);
        log.info("[{}] User rate by [{}] movie [{}]", userId, rate, movieId);
    }

    @Transactional
    public void updateMovieViewInfo(Long userId, Long movieId) {
        checkUserAndMovieIsExist(userId, movieId);
        userMoviesDAO.updateMovieViewInfo(userId, movieId);
        log.info("[{}] User update [{}] movie as watched", userId, movieId);

    }

    public Collection<Movie> getAllMoviesFromUserMoviesList(Long userId) {
        userService.getUserById(userId);
        final Collection<Movie> userMovies = userMoviesDAO.getAllMoviesFromUserMoviesList();
        if (userMovies.isEmpty()){
            log.info("[{}] User's movies list is empty", userId);
            throw new RuntimeException("List is empty");
        }
        return userMovies;
    }

    public Collection<Movie> getAllUnseenMoviesFromUserMoviesList(Long userId) {
        userService.getUserById(userId);
        final Collection<Movie> unseenUserMovies = userMoviesDAO.getAllMoviesFromUserMoviesList();
        if (unseenUserMovies.isEmpty()){
            log.info("[{}] User's unseen movies list is empty", userId);
            throw new RuntimeException("List is empty");
        }
        return unseenUserMovies;
    }

    private void checkUserAndMovieIsExist(Long userId, Long movieId) {
        userService.getUserById(userId);
        movieService.getMovieById(movieId);
    }

    private Double getMovieRating(Long movieId){
        final Collection<UserMovies> movies = userMoviesDAO.getMoviesWithRate();
        if (movies.isEmpty()){
            log.info("[{}] Movie have not rate", movieId);
            throw new RuntimeException("List is empty");
        }
        return movies.stream().mapToDouble(UserMovies::getRate).average().getAsDouble();
    }
}
