package com.example.midka.mapper;

import com.example.midka.dto.CategoryDto;
import com.example.midka.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "nameDto",source = "name")
    CategoryDto toDto(Category category);

    @Mapping(target = "name",source = "nameDto")
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categories);
}
