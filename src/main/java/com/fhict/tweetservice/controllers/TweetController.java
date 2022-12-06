package com.fhict.tweetservice.controllers;

import com.fhict.tweetservice.models.Tweet;
import com.fhict.tweetservice.services.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping()
    public ResponseEntity<Tweet> postTweet(@RequestBody Tweet tweet) {
        return tweetService.postTweet(tweet);
    }

    @GetMapping()
    public ResponseEntity<List<Tweet>> getAllTweets() {
        return tweetService.getAll();
    }

    @GetMapping("/{tweetId}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable int tweetId) {
        return tweetService.getTweetById(tweetId);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweet>> getTweetByUsername(@PathVariable String username) {
        return tweetService.getTweetByUsername(username);
    }

    @GetMapping("/gettweets/{userIds}")
    public List<Tweet> getTweetsByUserIds(@PathVariable List<String> userIds) {
        return tweetService.getTweetsByUserIds(userIds);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
