package com.moskalenko.bankcinema.api.client;

import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.entity.Director;

import java.util.Collection;

public interface DirectorClient {
    Director addDirector(DirectorDTO directorData);

    Director getDirectorById(Long directorId);

    Collection<Director> getAllDirectors();
}
