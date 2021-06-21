package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class UserDAO {
    public Optional<User> addUser(UserDTO userData) {
        return Optional.empty();
    }

    public Optional<User> getUserById(Long userId) {
        return Optional.empty();
    }

    public Set<User> getAllUser() {
        return null;
    }

}
