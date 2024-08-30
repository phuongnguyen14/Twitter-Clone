package org.example.twitterback.service;

import org.example.twitterback.exception.TwitException;
import org.example.twitterback.exception.UserException;
import org.example.twitterback.model.Like;
import org.example.twitterback.model.User;

import java.util.List;

public interface LikeService {

    public Like likeTwit(Long twitId, User user) throws TwitException, UserException;

    public List<Like> getAllLikes(Long twitId) throws TwitException;


}
