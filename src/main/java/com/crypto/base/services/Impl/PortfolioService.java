package com.crypto.base.services.Impl;

import com.crypto.base.dto.PortfolioTransactionReq;
import com.crypto.base.dto.*;
import com.crypto.base.entities.Portfolio;
import com.crypto.base.mapper.PortfolioMapper;
import com.crypto.base.repositories.PortfolioRepository;
import com.crypto.base.services.IPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PortfolioService implements IPortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;
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
}
