package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.entity.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorDAO extends CrudRepository<Director, Long> {
    Optional<Director> getDirectorById(Long id);
}
