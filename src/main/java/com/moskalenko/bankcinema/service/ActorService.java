package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.entity.Actor;
import com.moskalenko.bankcinema.dao.ActorDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

@Service
public class ActorService {

    private static final Logger log = LoggerFactory.getLogger(ActorService.class);
    private final ActorDAO actorDAO;

    public ActorService(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    @Transactional
    public Actor addActor(ActorDTO actorData) {
        final Actor actor = new Actor(actorData.getName(), actorData.getSurname());
        actorDAO.save(actor);
        log.info("[{}] Actor added", actor.getId());
        return actor;
    }

    public Collection<Actor> getAllActors() {
        final Set<Actor> actors = (Set<Actor>) actorDAO.findAll();
        if (actors.isEmpty()) {
            log.info("Actor's list is empty");
            throw new RuntimeException("List is empty");
        }
        return actors;
    }


    public Actor getActorById(Long actorId) {
        final Actor actor = actorDAO.getActorById(actorId).orElse(null);
        if (actor == null){
            log.info("[{}] Actor is not found", actorId);
            throw new RuntimeException("Actor is not found");
        }
        return actor;
    }
}
