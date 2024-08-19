package com.crypto.base.mapper;

import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserDtoRes;
import com.crypto.base.entities.Portfolio;
import com.crypto.base.entities.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(SaveUserReq saveUserReq);
    PortfolioDtoRes toDto(Portfolio portfolio);

    @AfterMapping
    default void linkComments(@MappingTarget User user) {
        user.getComments().forEach(comment -> comment.setUser(user));
    }

    UserDtoRes toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDtoRes userDtoRes, @MappingTarget User user);
}