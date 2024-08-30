package org.example.twitterback.controller;


import org.example.twitterback.service.TwitService;
import org.example.twitterback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/twit")
public class TwitController {
    @Autowired
    private TwitService twitService;
    private UserService userService;



}
