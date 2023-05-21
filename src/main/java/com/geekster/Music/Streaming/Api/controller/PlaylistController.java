package com.geekster.Music.Streaming.Api.controller;

import com.geekster.Music.Streaming.Api.model.PlayList;
import com.geekster.Music.Streaming.Api.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    PlaylistService playlistService;
    @PostMapping("/{userId}/create")
    public ResponseEntity<String> createPlaylist(@PathVariable Long userId, @RequestBody PlayList playlist) {
       boolean flag=playlistService.createPlaylist(userId,playlist);
        if(flag){
            return new ResponseEntity<>(playlist.toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The entered Id is not valid",HttpStatus.BAD_REQUEST);

    }
    @PutMapping("{id}")
    public ResponseEntity<String> updatePlaylist(@PathVariable Long id,@RequestBody PlayList playlist){
        boolean flag = playlistService.updatePlaylist(id, playlist);
        if(flag) {
            return new ResponseEntity<>(playlist.toString(), HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>("The entered Id is not valid",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("{id}/{playlistId}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Long id,@PathVariable Long playlistId){
        boolean flag = playlistService.deletePlaylist(id,playlistId);
        if(flag) {
            return new ResponseEntity<>(playlistId.toString(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("The entered Id is not valid",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlayList> getPlaylist(@PathVariable Long id){
        PlayList playList=playlistService.getPlaylist(id);
        return ResponseEntity.ok(playList);
    }
}
