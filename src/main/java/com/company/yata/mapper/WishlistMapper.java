package com.company.yata.mapper;

import com.company.yata.dto.WishlistDto;
import com.company.yata.models.Wishlist;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class WishlistMapper {
    public abstract Wishlist toEntity(WishlistDto dto);
    public abstract WishlistDto toDto(Wishlist wishlist);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Wishlist updateWishlistFromDto(WishlistDto dto, @MappingTarget Wishlist wishlist);
}
