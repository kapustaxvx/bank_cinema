package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.beans.Actor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class ActorDAO {
    public Optional<Actor> getActorById(Long actorId) {
        return Optional.empty();
    }

    public Collection<Actor> getAllActors() {
        return null;
    }

    public Actor addActor(Actor actorData) {
        return null;
    }
}
