package com.moskalenko.bankcinema.kafka;

import com.moskalenko.bankcinema.api.DTO.ActorDTO;
import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.DTO.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private static final Logger log = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, UserDTO> userDTOKafkaTemplate;
    private final KafkaTemplate<String, ActorDTO> actorDTOKafkaTemplate;
    private final KafkaTemplate<String, DirectorDTO> directorDTOKafkaTemplate;
    private final KafkaTemplate<String, MovieDTO> movieDTOKafkaTemplate;

    public ProducerService(KafkaTemplate<String, UserDTO> userDTOKafkaTemplate,
                           KafkaTemplate<String, ActorDTO> actorDTOKafkaTemplate,
                           KafkaTemplate<String, DirectorDTO> directorDTOKafkaTemplate,
                           KafkaTemplate<String, MovieDTO> movieDTOKafkaTemplate) {
        this.userDTOKafkaTemplate = userDTOKafkaTemplate;
        this.actorDTOKafkaTemplate = actorDTOKafkaTemplate;
        this.directorDTOKafkaTemplate = directorDTOKafkaTemplate;
        this.movieDTOKafkaTemplate = movieDTOKafkaTemplate;
    }

    public void produce(UserDTO user) {
        log.info("Producing the user " + user);
        userDTOKafkaTemplate.send("users-topic", user);
    }

    public void produce(ActorDTO actor) {
        log.info("Producing the actor " + actor);
        actorDTOKafkaTemplate.send("actors", actor);
    }

    public void produce(DirectorDTO director) {
        log.info("Producing the director " + director);
        directorDTOKafkaTemplate.send("directors", director);
    }

    public void produce(MovieDTO movie) {
        log.info("Producing the movie " + movie);
        movieDTOKafkaTemplate.send("movies", movie);
    }
}
