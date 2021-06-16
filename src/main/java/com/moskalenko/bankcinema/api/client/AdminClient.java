package com.moskalenko.bankcinema.api.client;

import com.moskalenko.bankcinema.api.beans.Actor;
import com.moskalenko.bankcinema.api.beans.Director;
import com.moskalenko.bankcinema.api.beans.Movie;
import com.moskalenko.bankcinema.api.beans.User;

import java.util.Collection;

public interface AdminClient {
    User addUser(User userData);

    Director addDirector(Director directorData);

    Actor addActor(Actor actorData);

    Movie addMovie(Movie movie);

    Collection<User> getAllUsers();

}
