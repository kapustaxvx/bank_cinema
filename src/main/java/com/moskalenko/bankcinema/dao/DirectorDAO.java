package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.entity.Director;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class DirectorDAO {
    public Optional<Director> addDirector(DirectorDTO directorData) {
        return Optional.empty();
    }

    public Set<Director> getAllDirectors() {
        return null;
    }

    public Optional<Director> getDirectorById(Long directorId) {
        return Optional.empty();
    }
}
