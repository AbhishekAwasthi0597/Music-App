package com.geekster.Music.Streaming.Api.repo;

import com.geekster.Music.Streaming.Api.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
