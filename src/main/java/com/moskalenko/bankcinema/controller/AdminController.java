package com.moskalenko.bankcinema.controller;


import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.entity.User;
import com.moskalenko.bankcinema.api.client.AdminClient;
import com.moskalenko.bankcinema.api.entity.Actor;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.kafka.ProducerService;
import com.moskalenko.bankcinema.service.ActorService;
import com.moskalenko.bankcinema.service.DirectorService;
import com.moskalenko.bankcinema.service.MovieService;
import com.moskalenko.bankcinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AdminController implements AdminClient {

    private final UserService userService;
    private final DirectorService directorService;
    private final ActorService actorService;
    private final MovieService movieService;
    private final ProducerService producerService;

    public AdminController(UserService userService, DirectorService directorService,
                           ActorService actorService, MovieService movieService,
                           ProducerService producerService) {
        this.userService = userService;
        this.directorService = directorService;
        this.actorService = actorService;
        this.movieService = movieService;
        this.producerService = producerService;
    }


    @Override
    @PostMapping("/users")
    public User addUser(@RequestBody UserDTO userData) {
        producerService.produce(userData);
        return userService.addUser(userData);
    }

    @Override
    @PostMapping("/directors")
    public Director addDirector(@RequestBody DirectorDTO directorData) {
        return directorService.addDirector(directorData);
    }

    @Override
    @PostMapping("/actors")
    public Actor addActor(@RequestBody ActorDTO actorData) {
        return actorService.addActor(actorData);
    }

    @Override
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody MovieDTO movieData) {
        return movieService.addMovie(movieData);
    }

    @Override
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @Override
    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @Override
    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/directors/{directorId}")
    public Director getDirectorById(@PathVariable Long directorId) {
        return directorService.getDirectorById(directorId);
    }

    @Override
    @GetMapping("/actors/{actorId}")
    public Actor getActorById(@PathVariable Long actorId) {
        return actorService.getActorById(actorId);
    }

    @Override
    @GetMapping("/directors")
    public Collection<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @Override
    @GetMapping("/actors")
    public Collection<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @Override
    @GetMapping("/movies")
    public Collection<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
