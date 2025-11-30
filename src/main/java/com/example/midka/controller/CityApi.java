package com.example.midka.controller;

import com.example.midka.dto.CityDto;
import com.example.midka.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityApi {
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(cityService.getById(id) ,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody CityDto cityDto){
        cityService.add(cityDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/id")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody CityDto cityDto){
        cityService.update(id, cityDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        cityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}