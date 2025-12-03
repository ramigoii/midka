package com.example.midka;

import com.example.midka.dto.CategoryDto;
import com.example.midka.mapper.CategoryMapper;
import com.example.midka.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void toDtoTest(){
        Category ent = new Category(1L,"name");
        CategoryDto dto = categoryMapper.toDto(ent);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());

        Assertions.assertEquals(ent.getId(),dto.getId());
        Assertions.assertEquals(ent.getName(),dto.getNameDto());
    }
    @Test
    void toEntityTest(){
        CategoryDto dto = new CategoryDto(1L,"name");
        Category ent = categoryMapper.toEntity(dto);
        Assertions.assertNotNull(ent);
        Assertions.assertNotNull(ent.getId());
        Assertions.assertNotNull(ent.getName());

        Assertions.assertEquals(dto.getId(),ent.getId());
        Assertions.assertEquals(dto.getNameDto(),ent.getName());
    }
    @Test
    void toDtoListTest(){
        List<Category> ents = new ArrayList<>();
        ents.add(new Category(1L,"name"));
        ents.add(new Category(2L,"name"));
        ents.add(new Category(3L,"name"));
        List<CategoryDto> dtos = categoryMapper.toDtoList(ents);
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0,dtos.size());
        Assertions.assertEquals(ents.size(),dtos.size());
        for(int i = 0;i<ents.size();i++){
            Category ent = ents.get(i);
            CategoryDto dto = categoryMapper.toDto(ent);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());

            Assertions.assertEquals(ent.getId(),dto.getId());
            Assertions.assertEquals(ent.getName(),dto.getNameDto());
        }

    }
}
