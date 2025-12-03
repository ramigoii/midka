package com.example.midka.service;

import com.example.midka.dto.CityDto;
import java.util.List;

public interface CityService {
    List<CityDto> getAll();
    CityDto getById(Long id);
    CityDto add(CityDto cityDto);
    CityDto update(Long id, CityDto cityDto);
    Boolean delete(Long id);
}