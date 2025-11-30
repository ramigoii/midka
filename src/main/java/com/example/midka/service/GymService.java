package com.example.midka.service;

import com.example.midka.dto.GymDto;
import java.util.List;

public interface GymService {
    List<GymDto> getAll();
    GymDto getById(Long id);
    GymDto add(GymDto gymDto);
    GymDto update(Long id, GymDto gymDto);
    Boolean delete(Long id);
}