package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.beans.Actor;
import com.moskalenko.bankcinema.dao.ActorDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ActorService {

    private static final Logger log = LoggerFactory.getLogger(ActorService.class);
    private  final ActorDAO actorDAO;

    public ActorService(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    public Actor addActor(Actor actorData) {
        return actorDAO.addActor(actorData);
    }

    public Collection<Actor> getAllActors() {
        return actorDAO.getAllActors();
    }

    public Actor getActorById(Long actorId) {
        Actor actor = actorDAO.getActorById(actorId).orElse(null);
        if (actor == null){
            log.info("[{}] Actor is not found", actorId);
            throw new RuntimeException("Actor is not found");
        }
        return actor;
    }
}
