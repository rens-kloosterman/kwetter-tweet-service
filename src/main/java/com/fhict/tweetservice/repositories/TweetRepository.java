package com.fhict.tweetservice.repositories;

import com.fhict.tweetservice.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {
    @Query("select t from Tweet t where t.userId in :userIds order by t.timeSent desc")
    List<Tweet> findAllByUserIds(@Param("userIds") List<String> userIds);
}
