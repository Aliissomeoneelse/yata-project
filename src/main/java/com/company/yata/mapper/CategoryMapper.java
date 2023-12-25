package com.company.yata.mapper;

import com.company.yata.dto.CategoryDto;
import com.company.yata.models.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract Category toEntity(CategoryDto dto);

    public abstract CategoryDto toDto(Category product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Category updateProductFromDto(CategoryDto dto, @MappingTarget Category product);
}
