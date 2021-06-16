package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.beans.Actor;
import com.moskalenko.bankcinema.api.beans.Director;
import com.moskalenko.bankcinema.api.beans.Movie;
import com.moskalenko.bankcinema.api.beans.User;
import com.moskalenko.bankcinema.api.client.AdminClient;
import com.moskalenko.bankcinema.service.ActorService;
import com.moskalenko.bankcinema.service.DirectorService;
import com.moskalenko.bankcinema.service.MovieService;
import com.moskalenko.bankcinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/admin")
public class AdminController implements AdminClient {

    private final UserService userService;
    private final DirectorService directorService;
    private final ActorService actorService;
    private final MovieService movieService;

    public AdminController(UserService userService, DirectorService directorService,
                           ActorService actorService, MovieService movieService) {
        this.userService = userService;
        this.directorService = directorService;
        this.actorService = actorService;
        this.movieService = movieService;
    }


    @Override
    @PostMapping("/users")
    public User addUser(@RequestBody User userData) {
        return userService.addUser(userData);
    }

    @Override
    @PostMapping("/directors")
    public Director addDirector(@RequestBody Director directorData) {
        return directorService.addDirector(directorData);
    }

    @Override
    @PostMapping("/actors")
    public Actor addActor(@RequestBody Actor actorData) {
        return actorService.addActor(actorData);
    }

    @Override
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movieData) {
        return movieService.addMovie(movieData);
    }

    @Override
    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
