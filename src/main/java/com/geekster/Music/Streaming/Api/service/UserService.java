package com.geekster.Music.Streaming.Api.service;

import com.geekster.Music.Streaming.Api.dto.SignInInput;
import com.geekster.Music.Streaming.Api.dto.SignInOutput;
import com.geekster.Music.Streaming.Api.dto.SignUpInput;
import com.geekster.Music.Streaming.Api.dto.SignUpOutput;
import com.geekster.Music.Streaming.Api.model.AuthenticationToken;
import com.geekster.Music.Streaming.Api.model.User;
import com.geekster.Music.Streaming.Api.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired TokenService tokenService;
    public SignUpOutput signup(SignUpInput signDto) {
        User user = iUserRepo.findFirstByEmail(signDto.getEmail());
        if (user != null) {
            throw new IllegalStateException("User Already exist!!!...");
        }
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signDto.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        user = new User(signDto.getFirstName(),signDto.getLastName() ,signDto.getEmail(), encryptedPassword, signDto.getPhoneNumber());
        iUserRepo.save(user);
        AuthenticationToken token = new AuthenticationToken(user);
        tokenService.saveToken(token);
        return new SignUpOutput("User registered", "User created successfully");

    }
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signin(SignInInput signInDto) {
        User user=iUserRepo.findFirstByEmail(signInDto.getEmail());
        if(user==null){
            throw new IllegalStateException("User is Invalid!!!...");
        }
        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }catch(Exception e){
            e.printStackTrace();
        }
        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());
        if(!isPasswordValid){
            throw  new IllegalStateException("Password is in Valid or sign up");
        }
        AuthenticationToken authToken = tokenService.getToken(user);
        return  new SignInOutput("Authentication Successfull !!!",authToken.getToken());
    }
}
