package com.example.midka.controller;

import com.example.midka.model.User;
import com.example.midka.service.CityService;
import com.example.midka.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {
    private final MyUserService myUserService;
    private final CityService cityService;

    @GetMapping
    public String get123(){
        return "q2323";
    }
    @PostMapping("/register")
    public void register(@RequestBody User model){
        myUserService.register(model);
    }
    @GetMapping("/city")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }

}
