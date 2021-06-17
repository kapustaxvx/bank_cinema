CREATE TABLE IF NOT EXISTS actors
    (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(20) NOT NULL,
        surname varchar(30) NOT NULL,
        birthdate TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS directors
    (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(20) NOT NULL,
        surname varchar(30) NOT NULL,
        birthdate TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    surname varchar(30) NOT NULL,
    birthdate TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS genres
    (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS movies
    (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        description VARCHAR(500),
        genre_id BIGINT REFERENCES genres(id) NOT NULL,
        average_rate DECIMAL,
        release_date TIMESTAMP NOT NULL,
        fees INT DEFAULT (0) NOT NULL
);

CREATE TABLE IF NOT EXISTS director_movies
    (
        director_id BIGINT REFERENCES directors(id) NOT NULL,
        movie_id BIGINT REFERENCES movies(id) NOT NULL,
        UNIQUE (director_id, movie_id)
);

CREATE TABLE  IF NOT EXISTS actor_movies
    (
        actor_id BIGINT REFERENCES actors(id) NOT NULL,
        movie_id BIGINT REFERENCES movies(id) NOT NULL,
        UNIQUE (actor_id, movie_id)
);

CREATE TABLE IF NOT EXISTS movie_rates
    (
        movie_id BIGINT REFERENCES movies(id) NOT NULL,
        user_id BIGINT REFERENCES users(id) NOT NULL,
        rate INT CHECK (rate>=0 AND rate<=10)NOT NULL,
        UNIQUE (movie_id, user_id)
);

CREATE TABLE IF NOT EXISTS user_movies_list
    (
        user_id BIGINT REFERENCES users(id) NOT NULL,
        movie_id BIGINT REFERENCES movies(id) NOT NULL,
        viewed BOOLEAN DEFAULT (false),
        UNIQUE (user_id, movie_id)
)