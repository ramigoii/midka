package com.example.midka.service.Impl;

import com.example.midka.dto.CityDto;
import com.example.midka.mapper.CityMapper;
import com.example.midka.model.City;
import com.example.midka.repository.CityRepository;
import com.example.midka.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

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
        return  cityMapper.toDto(cityRepository.findById(id).orElse(null));
    }

    @Override
    public CityDto add(CityDto cityDto) {
        City city = cityRepository.save(cityMapper.toEntity(cityDto));
        return cityMapper.toDto(city);
    }

    @Override
    public CityDto update(Long id, CityDto cityDto) {
        City city = cityRepository.findById(id).orElse(null);
        City cityUp = cityMapper.toEntity(cityDto);
        city.setId(cityUp.getId());
        city.setName(cityUp.getName());
        City cityq = cityRepository.save(city);
        return cityMapper.toDto(cityq);

    }

    @Override
    public Boolean delete(Long id) {
        cityRepository.deleteById(id);
        City check = cityRepository.findById(id).orElse(null);
        if(Objects.isNull(check)){
            return true;
        }
        return false;
    }
}