package org.example.twitterback.service;

import org.example.twitterback.exception.TwitException;
import org.example.twitterback.exception.UserException;
import org.example.twitterback.model.Like;
import org.example.twitterback.model.Twit;
import org.example.twitterback.model.User;
import org.example.twitterback.repository.LikeRepository;
import org.example.twitterback.repository.TwitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImplementation implements LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private TwitService twitService;
    @Autowired
    private TwitRepository twitRepository;

    @Override
    public Like likeTwit(Long twitId, User user) throws TwitException, UserException {
        Like isLikeExist = likeRepository.isLikeExist(user.getId(), twitId);

        if (isLikeExist != null) {
            likeRepository.deleteById(isLikeExist.getId());
            return isLikeExist;
        }

        Twit twit = twitService.findById(twitId);
        Like like = new Like();
        like.setTwit(twit);
        like.setUser(user);

        Like savedLike = likeRepository.save(like);
        twit.getLikes().add(savedLike);
        twitRepository.save(twit);

        return savedLike;
    }

    @Override
    public List<Like> getAllLikes(Long twitId) throws TwitException {

        Twit twit = twitService.findById(twitId);
        List<Like> likes = likeRepository.findByTwitId(twitId);
        return likes;
    }
}
