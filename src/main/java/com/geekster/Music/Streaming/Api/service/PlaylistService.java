package com.geekster.Music.Streaming.Api.service;

import com.geekster.Music.Streaming.Api.model.PlayList;
import com.geekster.Music.Streaming.Api.model.User;
import com.geekster.Music.Streaming.Api.repo.IPlaylistRepo;
import com.geekster.Music.Streaming.Api.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    IPlaylistRepo iPlaylistRepo;

    public boolean createPlaylist(Long userId, PlayList playlist) {
        Optional<User> user = iUserRepo.findById(userId);
        if(user.isPresent()){
            iPlaylistRepo.save(playlist);
            return true;
        }
        return false;
    }

    public boolean updatePlaylist(Long id, PlayList playlist) {
        Optional<User> user=iUserRepo.findById(id);
        if(user.isPresent()){
            playlist.setName(playlist.getName());
            playlist.setSongs(playlist.getSongs());
            iPlaylistRepo.save(playlist);
            return true;
        }
        return false;
    }

    public boolean deletePlaylist(Long id, Long playlistId) {
        Optional<User> user=iUserRepo.findById(id);
        if(user.isPresent()){
            iPlaylistRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public PlayList getPlaylist(Long id) {
        return  iPlaylistRepo.findById(id).get();
    }
}
