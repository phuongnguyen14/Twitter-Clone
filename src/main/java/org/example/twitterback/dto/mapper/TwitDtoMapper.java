package org.example.twitterback.dto.mapper;

import org.example.twitterback.dto.TwitDto;
import org.example.twitterback.dto.UserDto;
import org.example.twitterback.model.Twit;
import org.example.twitterback.model.User;
import org.example.twitterback.util.TwitUtil;

import java.util.ArrayList;
import java.util.List;

public class TwitDtoMapper {

    public static TwitDto toTwitDto(Twit twit, User reqUser){
        UserDto user = UserDtoMapper.toUserDto(twit.getUser());
        boolean isLiked = TwitUtil.isLikedByReqUser(reqUser, twit);
        boolean isRetwited=TwitUtil.isRetwitByReqUser(reqUser,twit);

        List<Long> retwitUserId = new ArrayList<>();

        for(User user1:twit.getRetwitUser()){
            retwitUserId.add(user1.getId());
        }
        TwitDto twitDto = new TwitDto();
        twitDto.setId(twit.getId());
        twitDto.setContent(twit.getContent());
        twitDto.setCreatedAt(twit.getCreatedAt());
        twitDto.setImage(twit.getImage());
        twitDto.setTotalLike(twit.getLikes().size());
        twitDto.setTotalReply(twit.getReplyTwit().size());
        twitDto.setTotalRetwit(twit.getRetwitUser().size());
        twitDto.setUser(user);
        twitDto.setLike(isLiked);
        twitDto.setRetwit(isRetwited);
        twitDto.setRetwitUserId(retwitUserId);
        twitDto.setReplyTwit(toTwitDtos(twit.getReplyTwit(),reqUser));
        twitDto.setVideo(twit.getVideo());

        return twitDto;
    }

    public static List<TwitDto> toTwitDtos(List<Twit> twits,User reqUser){
        List<TwitDto> twitDtos= new ArrayList<>();

        for (Twit twit: twits){
            TwitDto twitDto = toReplyTwitDto(twit,reqUser);
            twitDtos.add(twitDto);
        }
        return twitDtos;
    }

    private static TwitDto toReplyTwitDto(Twit twit, User reqUser) {
        UserDto user = UserDtoMapper.toUserDto(twit.getUser());
        boolean isLiked = TwitUtil.isLikedByReqUser(reqUser, twit);
        boolean isRetwited=TwitUtil.isRetwitByReqUser(reqUser,twit);

        List<Long> retwitUserId = new ArrayList<>();

        for(User user1:twit.getRetwitUser()){
            retwitUserId.add(user1.getId());
        }
        TwitDto twitDto = new TwitDto();
        twitDto.setId(twit.getId());
        twitDto.setContent(twit.getContent());
        twitDto.setCreatedAt(twit.getCreatedAt());
        twitDto.setImage(twit.getImage());
        twitDto.setTotalLike(twit.getLikes().size());
        twitDto.setTotalReply(twit.getReplyTwit().size());
        twitDto.setTotalRetwit(twit.getRetwitUser().size());
        twitDto.setUser(user);
        twitDto.setLike(isLiked);
        twitDto.setRetwit(isRetwited);
        twitDto.setRetwitUserId(retwitUserId);
        twitDto.setVideo(twit.getVideo());

        return twitDto;
    }

}


