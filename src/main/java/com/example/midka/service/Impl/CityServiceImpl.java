package com.example.midka.service.Impl;

import com.example.midka.dto.CityDto;
import com.example.midka.mapper.CityMapper;
import com.example.midka.model.City;
import com.example.midka.repository.CityRepository;
import com.example.midka.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityMapper cityMapper;
    private final CityRepository cityRepository;

    @Override
    public List<CityDto> getAll() {
        return cityMapper.toDtoList(cityRepository.findAll());
    }

    @Override
    public CityDto getById(Long id) {
        return  cityMapper.toDto(cityRepository.findById(id).orElseThrow());
    }

    @Override
    public void add(CityDto cityDto) {
        cityRepository.save(cityMapper.toEntity(cityDto));

    }

    @Override
    public void update(Long id, CityDto cityDto) {
        City city = cityRepository.findById(id).orElseThrow();
        City cityUp = cityMapper.toEntity(cityDto);
        city.setId(cityUp.getId());
        city.setName(cityUp.getName());
        cityRepository.save(city);

    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
