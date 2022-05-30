package com.fhict.tweetservice.services;

import com.fhict.tweetservice.models.Tweet;
import com.fhict.tweetservice.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
    @Autowired
    private final TweetRepository tweetRepo;

    public ResponseEntity<> postTweet(Tweet tweet) {
        if(!TweetValid) {
            return new ResponseEntity()
        }
    }
}
