package com.example.midka.mapper;

import com.example.midka.dto.CityDto;
import com.example.midka.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    @Mapping(target ="nameDto", source ="name")
    CityDto toDto(City city);

    @Mapping(target ="name", source ="nameDto")
    City toEntity(CityDto cityDto);

    List<CityDto> toDtoList(List<City> cities);
}
