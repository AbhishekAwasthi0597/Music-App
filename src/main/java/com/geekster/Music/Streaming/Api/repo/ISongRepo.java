package com.geekster.Music.Streaming.Api.repo;

import com.geekster.Music.Streaming.Api.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song,Long> {
}
