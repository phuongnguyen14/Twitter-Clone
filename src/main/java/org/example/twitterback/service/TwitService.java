package org.example.twitterback.service;


import org.example.twitterback.exception.TwitException;
import org.example.twitterback.exception.UserException;
import org.example.twitterback.model.Twit;
import org.example.twitterback.model.User;
import org.example.twitterback.request.TwitReplyRequest;

import java.util.List;

public interface TwitService {

    public Twit createTwit(Twit req, User user) throws UserException;
    public List<Twit> findAllTwit();
    public Twit retwit(Long twitId, User user) throws UserException, TwitException;
    public Twit findById(Long id) throws TwitException;
    public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException;
    public Twit removeFromRetwit(Long twitId, User user) throws TwitException, UserException;
    public Twit createReply(TwitReplyRequest req, User user) throws  TwitException;
    public List<Twit> getUserTwit(User user);
    public List<Twit> findByLikeContainUser(User user);

}
