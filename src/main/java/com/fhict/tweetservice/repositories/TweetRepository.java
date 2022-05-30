package com.fhict.tweetservice.repositories;

import com.fhict.tweetservice.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
}
