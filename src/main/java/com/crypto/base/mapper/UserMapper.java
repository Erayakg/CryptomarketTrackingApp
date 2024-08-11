package com.crypto.base.mapper;

import com.crypto.base.dto.UserDtoRes;
import com.crypto.base.entities.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserDtoRes userDtoRes);

    @AfterMapping
    default void linkPortfolios(@MappingTarget User user) {
        user.getPortfolios().forEach(portfolio -> portfolio.setUser(user));
    }

    @AfterMapping
    default void linkComments(@MappingTarget User user) {
        user.getComments().forEach(comment -> comment.setUser(user));
    }

    UserDtoRes toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDtoRes userDtoRes, @MappingTarget User user);
}