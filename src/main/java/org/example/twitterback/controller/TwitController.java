package org.example.twitterback.controller;


import org.example.twitterback.dto.TwitDto;
import org.example.twitterback.dto.mapper.TwitDtoMapper;
import org.example.twitterback.exception.TwitException;
import org.example.twitterback.exception.UserException;
import org.example.twitterback.model.Twit;
import org.example.twitterback.model.User;
import org.example.twitterback.request.TwitReplyRequest;
import org.example.twitterback.response.ApiResponse;
import org.example.twitterback.service.TwitService;
import org.example.twitterback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/twit")
public class TwitController {
    @Autowired
    private TwitService twitService;
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<TwitDto> createTwit(@RequestBody Twit req, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        Twit twit=twitService.createTwit(req,user);
        TwitDto twitDto= TwitDtoMapper.toTwitDto(twit,user);
        return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
    }

    @PostMapping("/reply")
    public ResponseEntity<TwitDto> replyTwit(@RequestBody TwitReplyRequest req, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        Twit twit=twitService.createReply(req ,user);
        TwitDto twitDto= TwitDtoMapper.toTwitDto(twit,user);
        return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
    }

    @PutMapping("/{twitId}/retwit")
    public ResponseEntity<TwitDto> retwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        Twit twit=twitService.retwit(twitId ,user);
        TwitDto twitDto= TwitDtoMapper.toTwitDto(twit,user);
        return new ResponseEntity<>(twitDto, HttpStatus.OK);
    }

    @GetMapping("/{twitId}")
    public ResponseEntity<TwitDto> findTwitById(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        Twit twit=twitService.findById(twitId);
        TwitDto twitDto= TwitDtoMapper.toTwitDto(twit,user);
        return new ResponseEntity<>(twitDto, HttpStatus.OK);
    }

    @DeleteMapping("/{twitId}")
    public ResponseEntity<ApiResponse> deleteTwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        twitService.deleteTwitById(twitId, user.getId());
        ApiResponse res = new ApiResponse();
        res.setMessage("Twit deleted successfully");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TwitDto>> getAllTwits(@RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        List<Twit> twits=twitService.findAllTwit();
        List<TwitDto> twitDtos= TwitDtoMapper.toTwitDtos(twits,user);
        return new ResponseEntity<>(twitDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TwitDto>> getUsersAllTwits(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        List<Twit> twits=twitService.getUserTwit(user);
        List<TwitDto> twitDtos= TwitDtoMapper.toTwitDtos(twits,user);
        return new ResponseEntity<>(twitDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/likes")
    public ResponseEntity<List<TwitDto>> findTwitByLikesContainesUser(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        User user=userService.findUserProfileByJwt(jwt);
        List<Twit> twits=twitService.findByLikeContainUser(user);
        List<TwitDto> twitDtos= TwitDtoMapper.toTwitDtos(twits,user);
        return new ResponseEntity<>(twitDtos, HttpStatus.OK);
    }







}
