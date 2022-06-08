package com.fhict.tweetservice.services;

import com.fhict.tweetservice.models.Tweet;
import com.fhict.tweetservice.repositories.TweetRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    private final TweetRepository tweetRepo;

    public TweetService(TweetRepository tweetRepo) {
        this.tweetRepo = tweetRepo;
    }

    public ResponseEntity<Tweet> postTweet(Tweet tweet) {
        if(tweet.getMessage().isBlank()) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        tweetRepo.save(tweet);
        return new ResponseEntity<>(tweet, new HttpHeaders(), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Tweet>> getAll() {
        List<Tweet> tweets = tweetRepo.findAll();
        return new ResponseEntity<>(tweets, new HttpHeaders(), HttpStatus.OK);
    }

    public ResponseEntity<List<Tweet>> getTweetByUsername(String username) {
        return null;
    }

    public ResponseEntity<Tweet> getTweetById(int tweetId) {
        return null;
    }

    public List<Tweet> getTweetsByUserIds(List<String> userIds) {
        return tweetRepo.findAllByUserIds(userIds);
    }
}
