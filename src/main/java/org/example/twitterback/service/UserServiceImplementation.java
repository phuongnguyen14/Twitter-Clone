package org.example.twitterback.service;


import org.example.twitterback.exception.UserException;
import org.example.twitterback.model.User;
import org.example.twitterback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long userId) throws UserException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found with id: " + userId));
        return user;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        return null;
    }

    @Override
    public User updateUser(Long userId, User user) throws UserException {
        return null;
    }

    @Override
    public User followUser(Long userId, User user) throws UserException {
        return null;
    }

    @Override
    public List<User> searchUser(String query) {
        return List.of();
    }
}
