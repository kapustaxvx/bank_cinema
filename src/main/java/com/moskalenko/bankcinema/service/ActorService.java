package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.entity.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ActorService {

    private static final Logger log = LoggerFactory.getLogger(ActorService.class);


    public Actor addActor(ActorDTO actorData) {
        return null;
    }

    public Collection<Actor> getAllActors() {
        return null;
    }

    public Actor getActorById(Long actorId) {
       /* Actor actor = actorDAO.getActorById(actorId).orElse(null);
        if (actor == null){
            log.info("[{}] Actor is not found", actorId);
            throw new RuntimeException("Actor is not found");
        }
        return actor;
    }*/
        return null;
    }
}
