package com.geekster.Music.Streaming.Api.controller;

import com.geekster.Music.Streaming.Api.model.Song;
import com.geekster.Music.Streaming.Api.service.AdminService;
import com.geekster.Music.Streaming.Api.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin")
public class AdminSongController {
    @Autowired
    AdminService adminService;
    @Autowired
    SongService songService;
    @PostMapping("/songs")
    public ResponseEntity<String> createSong(@RequestParam Long userId,@RequestBody @Valid Song song) {
        boolean flag = songService.createSong(userId,song);
        if(flag){
            return new ResponseEntity<>(song.toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The entered Id is not Admin's Id",HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/songs/{songId}")
    public ResponseEntity<String> updateSong(@PathVariable Long songId, @RequestBody @Valid Song updatedSong) {
        boolean update = songService.updateSong(songId, updatedSong);
        if (update) {
            return new ResponseEntity<>(updatedSong.toString(), HttpStatus.UPGRADE_REQUIRED);
        }
            return new ResponseEntity<>("The entered Id is not song's Id", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/songs/{songId}")
    public ResponseEntity<String> deleteSong(@PathVariable Long songId) {
        boolean deleted = songService.deleteSong(songId);
        if (deleted) {
            return new ResponseEntity<>(songId.toString(), HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>("The entered Id is not song's Id", HttpStatus.NOT_FOUND);

    }
}
