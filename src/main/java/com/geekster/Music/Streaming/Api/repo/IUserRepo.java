package com.geekster.Music.Streaming.Api.repo;

import com.geekster.Music.Streaming.Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
}
