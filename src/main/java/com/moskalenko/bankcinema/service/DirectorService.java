package com.moskalenko.bankcinema.service;


import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.dao.DirectorDAO;
import com.moskalenko.bankcinema.kafka.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class DirectorService {
    private static final Logger log = LoggerFactory.getLogger(DirectorService.class);
    private final DirectorDAO directorDAO;
    private final ProducerService producerService;

    public DirectorService(DirectorDAO directorDAO, ProducerService producerService) {
        this.directorDAO = directorDAO;
        this.producerService = producerService;
    }

    @Transactional
    public Director addDirector(DirectorDTO directorData) {
        final Director director = new Director(directorData.getName(), directorData.getSurname());
        directorDAO.save(director);
        log.info("[{}] Director added", director.getId());
       // producerService.produce(new DirectorDTO(director));
        return director;
    }

    public Collection<Director> getAllDirectors() {
        final Collection<Director> directors = (Collection<Director>) directorDAO.findAll();
        if (directors.isEmpty()) {
            log.info("Director's list is empty");
            throw new RuntimeException("List is empty");
        }
        log.info("Return all directors");
        return directors;
    }

    public Director getDirectorById(Long directorId) {
        final Director director = directorDAO.getDirectorById(directorId).orElse(null);
        if (director == null){
            log.info("[{}] Director is not found", directorId);
            throw new RuntimeException("Director is not found");
        }
        log.info("Return [{}] director", directorId);
        return director;
    }
}
