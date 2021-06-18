package com.moskalenko.bankcinema.api.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_movies")
public class UserMovies {

    @EmbeddedId
    private UserMoviesKey userMoviesKey;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "wathed")
    private Boolean isWatched;

    @Column(name = "rate", columnDefinition = "INT CHECK (rate>=0 AND rate<=10)")
    private Integer rate;

    public UserMovies() {
    }

    public UserMoviesKey getUserMoviesKey() {
        return userMoviesKey;
    }

    public void setUserMoviesKey(UserMoviesKey userMoviesKey) {
        this.userMoviesKey = userMoviesKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Boolean getWatched() {
        return isWatched;
    }

    public void setWatched(Boolean watched) {
        isWatched = watched;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
