package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.entity.User;
import com.moskalenko.bankcinema.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserService {
    private final static Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Transactional
    public User addUser(UserDTO userData) {
        final User user = new User(userData.getName(), userData.getSurname(), userData.getNickname());
        userDAO.save(user);
        log.info("[{}] User added", user.getId());
        return user;
    }

    public Collection<User> getAllUsers() {
        final Collection<User> users = (Collection<User>) userDAO.findAll();
        if (users.isEmpty()) {
            log.info("User's list is empty");
            throw new RuntimeException("List is empty");
        }
        log.info("Return all users");
        return users;
    }

    public User getUserById(Long userId) {
        final User user = userDAO.getUserById(userId).orElse(null);
        if (user == null) {
            log.info("[{}] User is not found", userId);
            throw new RuntimeException("User is not found");
        }
        log.info("Return [{}] user", userId);
        return user;
    }
}
