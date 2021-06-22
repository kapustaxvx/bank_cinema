package com.moskalenko.bankcinema.api.DTO;

import com.moskalenko.bankcinema.api.entity.Director;

public class DirectorDTO {
    private Long id;
    private String name;
    private String surname;

    public DirectorDTO() {
    }

    public DirectorDTO(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public DirectorDTO(Director director) {
        this.id = director.getId();
        this.name = director.getName();
        this.surname = director.getSurname();
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
