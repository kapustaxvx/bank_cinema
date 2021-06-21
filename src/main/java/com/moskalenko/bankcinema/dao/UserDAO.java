package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Long> {
    Optional<User> getUserById(Long id);
}
