package com.geekster.Music.Streaming.Api.service;

import com.geekster.Music.Streaming.Api.model.AuthenticationToken;
import com.geekster.Music.Streaming.Api.model.User;
import com.geekster.Music.Streaming.Api.repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    ITokenRepo tokenRepo;

    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepo.findByUser(user);
    }
}
