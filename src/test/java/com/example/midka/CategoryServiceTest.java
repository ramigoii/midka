package com.example.midka;

import com.example.midka.dto.CategoryDto;
import com.example.midka.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    private CategoryDto createOne(){
        CategoryDto dto = new CategoryDto();
        dto.setNameDto("name");
        return categoryService.addCategory(dto);
    }
    @Test
    void getAllTest(){
        createOne();
        List<CategoryDto> dtos = categoryService.getAll();
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0,dtos.size());
        for(int i = 0;i<dtos.size();i++){
            CategoryDto dto = dtos.get(i);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
        }
    }
    @Test
    void getById(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(ind).getId();
        CategoryDto dto = categoryService.getById(someId);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());

        CategoryDto check = categoryService.getById(-1L);
        Assertions.assertNull(check);

    }
    @Test
    void addTest(){
        CategoryDto dto = createOne();
        CategoryDto created = categoryService.addCategory(dto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getNameDto());

        Assertions.assertEquals(dto.getNameDto(),created.getNameDto());

        CategoryDto getDto = categoryService.getById(created.getId());
        Assertions.assertNotNull(getDto);
        Assertions.assertNotNull(getDto.getId());
        Assertions.assertNotNull(getDto.getNameDto());

        Assertions.assertEquals(created.getNameDto(),getDto.getNameDto());


    }
    @Test
    void updateTest(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(ind).getId();
        CategoryDto dto = createOne();
        CategoryDto before = categoryService.updateCategory(someId,dto);
        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getNameDto());

        Assertions.assertEquals(before.getNameDto(),dto.getNameDto());

        CategoryDto after = categoryService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getNameDto());

    }
    @Test
    void deleteTest(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(ind).getId();
        Assertions.assertTrue(categoryService.deleteCategory(someId));
        Assertions.assertNull(categoryService.getById(someId));
    }
}
