package com.moskalenko.bankcinema.api.beans;

import com.google.common.base.Preconditions;
import org.springframework.data.relational.core.sql.In;

import java.time.Instant;

public class MovieBuilder {

    private final Movie movie = new Movie();

    public static MovieBuilder create(){
        return new MovieBuilder();
    }

    public MovieBuilder withId(Long id){
        movie.id = id;
        return this;
    }

    public MovieBuilder withName(String name){
        movie.name = name;
        return this;
    }

    public MovieBuilder withDescription(String description){
        movie.description = description;
        return this;
    }

    public MovieBuilder withGenre(Genre genre){
        movie.genre = genre;
        return this;
    }

    public MovieBuilder withReleaseDate(Instant releaseDate){
        movie.releaseDate = releaseDate;
        return this;
    }

    public MovieBuilder withRate(Double rate){
        movie.rate = rate;
        return this;
    }

    public MovieBuilder withFees(Integer fees){
        movie.fees = fees;
        return this;
    }

    public Movie build(){
        Preconditions.checkArgument(movie.id!= null);
        Preconditions.checkArgument(movie.name!= null);
        Preconditions.checkArgument(movie.genre!= null);
        Preconditions.checkArgument(movie.releaseDate!= null);
        Preconditions.checkArgument(movie.fees!= null);

        return movie;
    }
}
