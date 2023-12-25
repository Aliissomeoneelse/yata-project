package com.company.yata.mapper;

import com.company.yata.dto.ProductDto;
import com.company.yata.models.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract Product toEntity(ProductDto dto);
    public abstract ProductDto toDto(Product product);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Product updateProductFromDto(ProductDto dto, @MappingTarget Product product);
}
