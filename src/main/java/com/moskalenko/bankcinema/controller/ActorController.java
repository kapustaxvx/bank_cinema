package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.client.ActorClient;
import com.moskalenko.bankcinema.api.entity.Actor;
import com.moskalenko.bankcinema.service.ActorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/actors")
public class ActorController implements ActorClient {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    @PostMapping
    @ApiOperation(value = "Add new actor")
    public Actor addActor(@RequestBody ActorDTO actorData) {
        return actorService.addActor(actorData);
    }

    @Override
    @PutMapping("/{actorId}/movies/{movieId}")
    @ApiOperation(value = "Add movie in the actor's list")
    public @ResponseBody String addActorToMovie(@PathVariable Long actorId, @PathVariable Long movieId) {
        actorService.addActorToMovie(actorId, movieId);
        return "Movie added";
    }

    @Override
    @GetMapping("/{actorId}")
    @ApiOperation(value = "Get actor by id")
    public Actor getActorById(@PathVariable Long actorId) {
        return actorService.getActorById(actorId);
    }


    @Override
    @GetMapping
    @ApiOperation("Get list of all actors")
    public Collection<Actor> getAllActors() {
        return actorService.getAllActors();
    }
}
