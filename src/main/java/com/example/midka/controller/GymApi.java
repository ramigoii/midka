package com.example.midka.controller;

import com.example.midka.dto.GymDto;
import com.example.midka.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gym")
public class GymApi {
    private final GymService gymService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(gymService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(gymService.getById(id) ,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody GymDto gymDto){
        gymService.add(gymDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/id")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody GymDto gymDto){
        gymService.update(id, gymDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        gymService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
