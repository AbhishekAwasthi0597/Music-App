package com.geekster.Music.Streaming.Api.controller;

import com.geekster.Music.Streaming.Api.dto.SignInInput;
import com.geekster.Music.Streaming.Api.dto.SignInOutput;
import com.geekster.Music.Streaming.Api.dto.SignUpInput;
import com.geekster.Music.Streaming.Api.dto.SignUpOutput;
import com.geekster.Music.Streaming.Api.model.Song;
import com.geekster.Music.Streaming.Api.model.User;
import com.geekster.Music.Streaming.Api.service.SongService;
import com.geekster.Music.Streaming.Api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
   @Autowired
   UserService userService;
   @Autowired
    SongService songService;
    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signDto){
        return userService.signup(signDto);
    }
    @PostMapping("/signin")
    public SignInOutput signin(@RequestBody SignInInput signInDto){
        return  userService.signin(signInDto);
    }
    @GetMapping("song")
    public ResponseEntity<List<Song>> getAllSong(){
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

}
