package com.moskalenko.bankcinema.api.DTO;

import com.moskalenko.bankcinema.api.entity.Actor;

public class ActorDTO {
    private Long id;
    private String name;
    private String surname;


    public ActorDTO() {
    }

    public ActorDTO(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public ActorDTO(Actor actor){
        this.id = actor.getId();
        this.name = actor.getName();
        this.surname = actor.getSurname();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
