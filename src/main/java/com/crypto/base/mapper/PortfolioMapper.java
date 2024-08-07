package com.crypto.base.mapper;

import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.entities.Portfolio;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface PortfolioMapper {
    Portfolio toEntity(PortfolioDtoRes portfolioDtoRes);

    @AfterMapping
    default void linkTransactions(@MappingTarget Portfolio portfolio) {
        portfolio.getTransactions().forEach(transaction -> transaction.setPortfolio(portfolio));
    }

    @AfterMapping
    default void linkLikes(@MappingTarget Portfolio portfolio) {
        portfolio.getLikes().forEach(like -> like.setPortfolio(portfolio));
    }

    @AfterMapping
    default void linkComments(@MappingTarget Portfolio portfolio) {
        portfolio.getComments().forEach(comment -> comment.setPortfolio(portfolio));
    }

    PortfolioDtoRes toDto(Portfolio portfolio);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Portfolio partialUpdate(PortfolioDtoRes portfolioDtoRes, @MappingTarget Portfolio portfolio);
}