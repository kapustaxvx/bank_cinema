package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.client.ActorClient;
import com.moskalenko.bankcinema.api.entity.Actor;
import com.moskalenko.bankcinema.service.ActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/actors")
public class ActorController implements ActorClient {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    @PostMapping
    public Actor addActor(@RequestBody ActorDTO actorData) {
        return actorService.addActor(actorData);
    }

    @Override
    @PutMapping("/{actorId}/movies/{movieId}")
    public void addActorToMovie(@PathVariable Long actorId, @PathVariable Long movieId) {
        actorService.addActorToMovie(actorId, movieId);
    }

    @Override
    @GetMapping("/{actorId}")
    public Actor getActorById(@PathVariable Long actorId) {
        return actorService.getActorById(actorId);
    }


    @Override
    @GetMapping
    public Collection<Actor> getAllActors() {
        return actorService.getAllActors();
    }
}
