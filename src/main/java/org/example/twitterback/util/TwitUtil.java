package org.example.twitterback.util;

import org.example.twitterback.model.Like;
import org.example.twitterback.model.Twit;
import org.example.twitterback.model.User;

public class TwitUtil {

    public final static boolean isLikedByReqUser(User reqUser, Twit twit){

        for(Like like: twit.getLikes()){
            if(like.getUser().getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;


    }
    public final static boolean isRetwitByReqUser(User reqUser, Twit twit){
        for(User user:twit.getRetwitUser()){
            if (user.getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;
    }

}
