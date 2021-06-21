package com.moskalenko.bankcinema.api.DTO;

public class MovieRatingDTO {
    private Long movieId;
    private Long userId;
    private Boolean isWatched;
    private Integer rate;

    public MovieRatingDTO() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public Boolean getWatched() {
        return isWatched;
    }

    public Integer getRate() {
        return rate;
    }
}
