package com.example.midka;

import com.example.midka.dto.CityDto;
import com.example.midka.mapper.CityMapper;
import com.example.midka.model.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CityMapperTest {
    @Autowired
    private CityMapper cityMapper;

    @Test
    void toDtoTest(){
        City ent = new City(1L,"name");
        CityDto dto = cityMapper.toDto(ent);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());

        Assertions.assertEquals(ent.getId(),dto.getId());
        Assertions.assertEquals(ent.getName(),dto.getNameDto());
    }
    @Test
    void toEntityTest(){
        CityDto dto = new CityDto(1L,"name");
        City ent = cityMapper.toEntity(dto);
        Assertions.assertNotNull(ent);
        Assertions.assertNotNull(ent.getId());
        Assertions.assertNotNull(ent.getName());

        Assertions.assertEquals(dto.getId(),ent.getId());
        Assertions.assertEquals(dto.getNameDto(),ent.getName());
    }
    @Test
    void toDtoListTest(){
        List<City> ents = new ArrayList<>();
        ents.add(new City(1L,"name"));
        ents.add(new City(2L,"name"));
        ents.add(new City(3L,"name"));
        List<CityDto> dtos = cityMapper.toDtoList(ents);
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0,dtos.size());
        Assertions.assertEquals(ents.size(),dtos.size());
        for(int i = 0;i<ents.size();i++){
            City ent = ents.get(i);
            CityDto dto = cityMapper.toDto(ent);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());

            Assertions.assertEquals(ent.getId(),dto.getId());
            Assertions.assertEquals(ent.getName(),dto.getNameDto());
        }

    }
}
