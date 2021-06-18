package com.moskalenko.bankcinema.api.client;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.entity.User;
import com.moskalenko.bankcinema.api.entity.Actor;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.api.entity.Movie;

import java.util.Collection;

public interface AdminClient {
    User addUser(UserDTO userData);

    Director addDirector(DirectorDTO directorData);

    Actor addActor(ActorDTO actorData);

    Movie addMovie(MovieDTO movieData);

    User getUserById(Long userId);

    Movie getMovieById(Long movieId);

    Collection<User> getAllUsers();

    Director getDirectorById(Long directorId);

    Actor getActorById(Long actorId);

    Collection<Director> getAllDirectors();

    Collection<Actor> getAllActors();

    Collection<Movie> getAllMovies();
}

