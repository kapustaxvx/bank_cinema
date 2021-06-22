package com.moskalenko.bankcinema.api.DTO;

import com.moskalenko.bankcinema.api.entity.Genre;
import com.moskalenko.bankcinema.api.entity.Movie;

public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private Genre genre;
    private Double rating;
    private Integer fees;
    private Long directorId;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String description, Genre genre, Double rating, Integer fees, Long directorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.fees = fees;
        this.directorId = directorId;
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.genre = movie.getGenre();
        this.rating = movie.getRating();
        this.fees = movie.getFees();
        this.directorId = movie.getDirector().getId();
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

    public Long getDirectorId() {
        return directorId;
    }
}
