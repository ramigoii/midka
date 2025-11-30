package com.example.midka.mapper;

import com.example.midka.dto.GymDto;
import com.example.midka.model.Gym;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GymMapper {
    @Mapping(target ="nameDto", source ="name")
    GymDto toDto(Gym gym);

    @Mapping(target ="name", source ="nameDto")
    Gym toEntity(GymDto gymDto);

    List<GymDto> toDtoList(List<Gym> gyms);
}