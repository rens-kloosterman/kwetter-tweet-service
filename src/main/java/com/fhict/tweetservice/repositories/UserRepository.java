package com.fhict.tweetservice.repositories;

import com.fhict.tweetservice.models.AppUser;
//import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository {//extends JpaRepository<User, Long> {
    AppUser findByUsername(String username);
}
