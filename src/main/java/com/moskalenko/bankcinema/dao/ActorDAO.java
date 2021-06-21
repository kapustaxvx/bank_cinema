package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ActorDAO extends CrudRepository<Actor, Long> {
    Optional<Actor> getActorById(Long id);
    Collection<Actor> findAll();
}
