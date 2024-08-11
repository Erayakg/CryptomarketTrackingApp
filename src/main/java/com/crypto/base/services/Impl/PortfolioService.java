package com.crypto.base.services.Impl;

import com.crypto.base.constant.PortfolioErrorMessage;
import com.crypto.base.dto.PortfolioTransactionReq;
import com.crypto.base.dto.*;
import com.crypto.base.entities.Portfolio;
import com.crypto.base.exceptions.CreateEntityException;
import com.crypto.base.mapper.PortfolioMapper;
import com.crypto.base.repositories.PortfolioRepository;
import com.crypto.base.services.IPortfolioService;
import com.crypto.base.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PortfolioService implements IPortfolioService {


    private final PortfolioRepository portfolioRepository;

    private final PortfolioMapper portfolioMapper;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, PortfolioMapper portfolioMapper) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
    }


    @Override
    public void updatePortfolio(PortfolioTransactionReq transactionReq) {

    }

    @Override
    public List<PortfolioDtoRes> getAllPortfolio() {

        List<Portfolio> portfolios = portfolioRepository.findAll();

        List<PortfolioDtoRes> portfolioDtoRes = portfolios.stream()
                .map(portfolioMapper::toDto)
                .toList();

        return portfolioDtoRes;
    }

    @Override
    public PortfolioDtoRes createPortfolio(CreatePortfolioDto createPortfolioDto) {
        if (createPortfolioDto.getName() == null || createPortfolioDto.getDescription() == null ) {
            throw new BadRequestException(PortfolioErrorMessage.REQUEST_FAILED);
        }
        try {
            Portfolio portfolio = new Portfolio();

            portfolio.setName(createPortfolioDto.getName());
            portfolio.setDescription(createPortfolioDto.getDescription());
            Portfolio save = portfolioRepository.save(portfolio);
            PortfolioDtoRes dto = portfolioMapper.toDto(save);
            return dto;
        }catch (Exception e) {
        throw new CreateEntityException(PortfolioErrorMessage.PORTFOLIO_CREATE_FAILED);
        }
    }

    @Override
    public PortfolioDtoRes getPortfolioById(long id) {
        return null;
    }

    @Override
    public void deletePortfolio(long id) {

    }
}
