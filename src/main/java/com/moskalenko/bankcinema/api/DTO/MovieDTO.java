package com.moskalenko.bankcinema.api.DTO;

import com.moskalenko.bankcinema.api.entity.Genre;

public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private Genre genre;
    private Double rating;
    private Integer fees;

    public MovieDTO() {
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getFees() {
        return fees;
    }
}
