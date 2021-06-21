package com.moskalenko.bankcinema.service;


import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.dao.DirectorDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

@Service
public class DirectorService {
    private static final Logger log = LoggerFactory.getLogger(DirectorService.class);
    private final DirectorDAO directorDAO;

    public DirectorService(DirectorDAO directorDAO) {
        this.directorDAO = directorDAO;
    }

    @Transactional
    public Director addDirector(DirectorDTO directorData) {
        final Director director = directorDAO.addDirector(directorData).orElse(null);
        if (director == null){
            log.info("Director was not added: "+ directorData.toString());
            throw new RuntimeException("Director was not added");
        }
        log.info("[{}] Director added", director.getId());
        return director;
    }

    public Collection<Director> getAllDirectors() {
        final Set<Director> directors = directorDAO.getAllDirectors();
        if (directors.isEmpty()) {
            log.info("Director's list is empty");
            throw new RuntimeException("List is empty");
        }
        return directors;
    }

    public Director getDirectorById(Long directorId) {
        final Director director = directorDAO.getDirectorById(directorId).orElse(null);
        if (director == null){
            log.info("[{}] Director is not found", directorId);
            throw new RuntimeException("Director is not found");
        }
        return director;
    }
}
