package com.example.midka;

import com.example.midka.dto.CityDto;
import com.example.midka.service.CityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CityServiceTest {
    @Autowired
    private CityService cityService;
    private CityDto createOne(){
        CityDto dto = new CityDto();
        dto.setNameDto("name");
        return cityService.add(dto);
    }
    @Test
    void getAllTest(){
        createOne();
        List<CityDto> dtos = cityService.getAll();
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0,dtos.size());
        for(int i = 0;i<dtos.size();i++){
            CityDto dto = dtos.get(i);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
        }
    }
    @Test
    void getById(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(cityService.getAll().size());
        Long someId = cityService.getAll().get(ind).getId();
        CityDto dto = cityService.getById(someId);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());

        CityDto check = cityService.getById(-1L);
        Assertions.assertNull(check);

    }
    @Test
    void addTest(){
        CityDto dto = createOne();
        CityDto created = cityService.add(dto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getNameDto());

        Assertions.assertEquals(dto.getNameDto(),created.getNameDto());

        CityDto getDto = cityService.getById(created.getId());
        Assertions.assertNotNull(getDto);
        Assertions.assertNotNull(getDto.getId());
        Assertions.assertNotNull(getDto.getNameDto());

        Assertions.assertEquals(created.getNameDto(),getDto.getNameDto());


    }
    @Test
    void updateTest(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(cityService.getAll().size());
        Long someId = cityService.getAll().get(ind).getId();
        CityDto dto = createOne();
        CityDto before = cityService.update(someId,dto);
        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getNameDto());

        Assertions.assertEquals(before.getNameDto(),dto.getNameDto());

        CityDto after = cityService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getNameDto());

    }
    @Test
    void deleteTest(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(cityService.getAll().size());
        Long someId = cityService.getAll().get(ind).getId();
        Assertions.assertTrue(cityService.delete(someId));
        Assertions.assertNull(cityService.getById(someId));
    }
}
