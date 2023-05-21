package com.geekster.Music.Streaming.Api.service;

import com.geekster.Music.Streaming.Api.model.Song;
import com.geekster.Music.Streaming.Api.model.User;
import com.geekster.Music.Streaming.Api.repo.ISongRepo;
import com.geekster.Music.Streaming.Api.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    ISongRepo iSongRepo;
    @Autowired
    IUserRepo iUserRepo;
    public boolean createSong(Long userId,Song song) {
        User user = iUserRepo.findById(userId).get();
        boolean flag = user.getEmail().endsWith("@admin.com");
        if(flag){
            iSongRepo.save(song);
            return true;
        }
        return false;
    }

    public boolean updateSong(Long songId, Song updatedSong) {
      Song song=iSongRepo.findById(songId).get();
      if(song!=null){
          song.setTitle(updatedSong.getTitle());
          song.setArtist(updatedSong.getArtist());
          iSongRepo.save(updatedSong);
          return true;
      }
      return  false;
    }

    public boolean deleteSong(Long songId) {
        Song song=iSongRepo.findById(songId).get();
        if(song!=null){
            iSongRepo.deleteById(songId);
            return true;
        }
        return false;
    }

    public List<Song> getAllSongs() {
        return iSongRepo.findAll();
    }
}
