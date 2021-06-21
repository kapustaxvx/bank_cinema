package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.entity.Actor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class ActorDAO {
    public Optional<Actor> addActor(ActorDTO actorData) {
        return Optional.empty();
    }

    public Set<Actor> getAllActors() {
        return null;
    }

    public Optional<Actor> getActorById(Long actorId) {
        return Optional.empty();
    }
}
