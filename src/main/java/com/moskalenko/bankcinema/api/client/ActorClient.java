package com.moskalenko.bankcinema.api.client;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.entity.Actor;

import java.util.Collection;

public interface ActorClient {
    Actor addActor(ActorDTO actorData);

    void addActorToMovie(Long actorId, Long movieId);

    Actor getActorById(Long actorId);

    Collection<Actor> getAllActors();
}
