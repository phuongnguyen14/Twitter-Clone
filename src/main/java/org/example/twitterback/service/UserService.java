package org.example.twitterback.service;


import org.example.twitterback.exception.UserException;
import org.example.twitterback.model.User;

import java.util.List;

public interface UserService {

    public User findUserById(Long id) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
    public User updateUser(Long userId, User user) throws UserException;
    public User followUser(Long userId, User user) throws UserException;

    public List<User> searchUser(String query);

}
