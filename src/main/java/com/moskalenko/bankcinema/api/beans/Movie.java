package com.moskalenko.bankcinema.api.beans;

import java.time.Instant;
import java.util.Objects;

public class Movie {
    Long id;
    String name;
    String description;
    Genre genre;
    Instant releaseDate;
    Double rate;
    Integer fees;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }

    public Double getRate() {
        return rate;
    }

    public Integer getFees() {
        return fees;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(description, movie.description) && genre == movie.genre && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(rate, movie.rate) && Objects.equals(fees, movie.fees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, genre, releaseDate, rate, fees);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                ", releaseDate=" + releaseDate +
                ", rate=" + rate +
                ", fees=" + fees +
                '}';
    }
}
