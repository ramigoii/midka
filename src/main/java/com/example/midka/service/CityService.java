package com.example.midka.service;

import com.example.midka.dto.CityDto;
import java.util.List;

public interface CityService {
    List<CityDto> getAll();
    CityDto getById(Long id);
    void add(CityDto cityDto);
    void update(Long id, CityDto cityDto);
    void delete(Long id);
}