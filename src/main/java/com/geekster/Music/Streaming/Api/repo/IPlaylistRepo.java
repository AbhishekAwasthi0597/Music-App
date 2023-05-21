package com.geekster.Music.Streaming.Api.repo;

import com.geekster.Music.Streaming.Api.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepo extends JpaRepository<PlayList,Long> {
}
