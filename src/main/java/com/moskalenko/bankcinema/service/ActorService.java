package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.entity.Actor;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.dao.ActorDAO;
import com.moskalenko.bankcinema.kafka.ProducerService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ActorService {

    private static final Logger log = LoggerFactory.getLogger(ActorService.class);
    private final ActorDAO actorDAO;
    private final MovieService movieService;
    private final ProducerService producerService;

    public ActorService(ActorDAO actorDAO, MovieService movieService,
                        ProducerService producerService) {
        this.actorDAO = actorDAO;
        this.movieService = movieService;
        this.producerService = producerService;
    }

    @Transactional
    @Counted(value = "add.actor.count",
            description = "Total number of requests of calls add actor method")
    public Actor addActor(ActorDTO actorData) {
        final Actor actor = new Actor(actorData.getName(), actorData.getSurname());
        actorDAO.save(actor);
        log.info("[{}] Actor added", actor.getId());
       // producerService.produce(new ActorDTO(actor));
        return actor;
    }

    @Timed(value = "get.actors.time",
            description = "Total number of requests of calls get all actors")
    @Counted(value = "get.actors.count",
            description = "Total number of requests of calls get all actors method")
    public Collection<Actor> getAllActors() {
        final Collection<Actor> actors = actorDAO.findAll();
        if (actors.isEmpty()) {
            log.info("Actor's list is empty");
            throw new RuntimeException("List is empty");
        }
        log.info("Return all actors");
        return actors;
    }


    @Timed(value = "get.actor.time",
            description = "Total number of requests of calls get actor by id method")
    @Counted(value = "get.actor.count",
            description = "Total number of requests of calls get actor by id method")
    public Actor getActorById(Long actorId) {
        final Actor actor = actorDAO.getActorById(actorId).orElse(null);
        if (actor == null) {
            log.info("[{}] Actor is not found", actorId);
            throw new RuntimeException("Actor is not found");
        }
        log.info("Return [{}] actor", actorId);
        return actor;
    }

    @Counted(value = "add.actor.to.movie.count",
            description = "Total number of requests of calls add actor to movie method")
    public void addActorToMovie(Long actorId, Long movieId) {
        final Actor actor = actorDAO.getActorById(actorId).orElse(null);
        if (actor == null) {
            log.info("[{}] Actor is not found", actorId);
            throw new RuntimeException("Actor is not found");
        }
        final Movie movie = movieService.getMovieById(movieId);
        actor.getMovies().add(movie);
        log.info("[{}] Movie added to [{}] actor", movieId, actorId);
        actorDAO.save(actor);
    }
}
