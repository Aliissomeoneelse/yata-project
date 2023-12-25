package com.company.yata.mapper;

import com.company.yata.dto.ImageDto;
import com.company.yata.models.Image;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class ImageMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Image toEntity(ImageDto dto);

    public abstract ImageDto toDto(Image image);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateImagesFromDto(ImageDto dto, @MappingTarget Image image);

    public abstract Set<ImageDto> toSetDto(Set<Image> file);
}
