package com.fhict.tweetservice.controllers;

import com.fhict.tweetservice.models.Tweet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    @GetMapping()
    public String test() {
        return "test";
    }

    @PostMapping()
    public ResponseEntity<> postTweet(@RequestBody Tweet tweet) {

    }
}
