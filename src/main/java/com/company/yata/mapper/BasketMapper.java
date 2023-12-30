package com.company.yata.mapper;

import com.company.yata.dto.BasketDto;
import com.company.yata.models.Basket;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class BasketMapper {
    public abstract Basket toEntity(BasketDto dto);
    public abstract BasketDto toDto(Basket basket);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Basket updateBasketFromDto(BasketDto dto, @MappingTarget Basket basket);
}