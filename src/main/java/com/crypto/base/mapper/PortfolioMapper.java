package com.crypto.base.mapper;

import com.crypto.base.dto.PortfolioDtoReq;
import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.entities.Portfolio;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PortfolioMapper {

    Portfolio toEntity(PortfolioDtoReq portfolioDtoReq);

    PortfolioDtoRes toDto(Portfolio portfolio);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Portfolio partialUpdate(PortfolioDtoReq portfolioDtoReq, @MappingTarget Portfolio portfolio);
}