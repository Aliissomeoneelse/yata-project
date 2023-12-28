package com.company.yata.mapper;

import com.company.yata.dto.CardDto;
import com.company.yata.models.Card;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class CardMapper {
    public abstract Card toEntity(CardDto dto);

    public abstract CardDto toDto(Card card);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Card updateCardFromDto(CardDto dto, @MappingTarget Card card);
}
