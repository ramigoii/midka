package com.example.midka.service.Impl;

import com.example.midka.dto.GymDto;
import com.example.midka.mapper.GymMapper;
import com.example.midka.model.Gym;
import com.example.midka.repository.GymRepository;
import com.example.midka.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService{
    private final GymMapper gymMapper;
    private final  GymRepository gymRepository;

    @Override
    public List<GymDto> getAll() {
        return gymMapper.toDtoList(gymRepository.findAll());
    }

    @Override
    public GymDto getById(Long id) {
        return gymMapper.toDto(gymRepository.findById(id).orElseThrow());
    }

    @Override
    public GymDto add(GymDto gymDto) {
        return gymMapper.toDto(gymRepository.save(gymMapper.toEntity(gymDto)));

    }

    @Override
    public GymDto update(Long id, GymDto gymDto) {
        Gym gym = gymRepository.findById(id).orElseThrow();
        Gym gymUp = gymMapper.toEntity(gymDto);
        gym.setId(gymUp.getId());
        gym.setName(gymUp.getName());
        return gymMapper.toDto(gymRepository.save(gym));

    }

    @Override
    public Boolean delete(Long id) {
        gymRepository.deleteById(id);
        Gym gym = gymRepository.findById(id).orElse(null);
        if(Objects.isNull(gym)){
            return true;
        }
        return false;
    }
}
