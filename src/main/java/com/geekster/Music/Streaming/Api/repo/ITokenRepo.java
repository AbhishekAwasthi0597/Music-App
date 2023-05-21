package com.geekster.Music.Streaming.Api.repo;

import com.geekster.Music.Streaming.Api.model.AuthenticationToken;
import com.geekster.Music.Streaming.Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByToken(String token);

    AuthenticationToken findByUser(User user);
}
