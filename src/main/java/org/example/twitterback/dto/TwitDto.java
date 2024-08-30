package org.example.twitterback.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TwitDto {

    private Long id;
    private String content;
    private String image;
    private String video;
    private  UserDto user;
    private LocalDateTime createdAt;
    private int totalLike;
    private int totalReply;
    private int totalRetwit;
    private boolean isLike;
    private boolean isRetwit;
    private List<Long> retwitUserId;
    private List<TwitDto> replyTwit;

}
