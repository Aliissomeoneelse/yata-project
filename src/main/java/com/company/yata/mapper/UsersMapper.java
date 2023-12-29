package com.company.yata.mapper;

import com.company.yata.dto.UsersDto;
import com.company.yata.models.Users;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class UsersMapper {
    public abstract Users toEntity(UsersDto dto);

    public abstract UsersDto toDto(Users users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Users updateUsersFromDto(UsersDto dto, @MappingTarget Users users);
}
