package com.fhict.tweetservice.repositories;

import com.fhict.tweetservice.models.AppUser;
import org.springframework.stereotype.Component;

@Component
public class FakeUserRepo implements UserRepository{
    @Override
    public AppUser findByUsername(String username) {
        AppUser appUser = new AppUser();
        appUser.setUsername("test");
        appUser.setPassword("test");
        return appUser;
    }
}
