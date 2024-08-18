package com.crypto.base.services.Impl;

import com.crypto.base.dto.*;
import com.crypto.base.mapper.PortfolioMapper;
import com.crypto.base.repositories.PortfolioRepository;
import com.crypto.base.services.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public PortfolioDtoRes updatePortfolio(PortfolioDtoReq portfolioDtoReq) {
        return null;
    }

    @Override
    public List<PortfolioDtoRes> getAllPortfolio() {
        return List.of();
    }

    @Override
    public PortfolioDtoRes createPortfolio(Long id,PortfolioDtoReq portfolioDtoReq) {

        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();


        return null;
    }

    @Override
    public PortfolioDtoRes getPortfolioById(long id) {
        return null;
    }

    @Override
    public void deletePortfolio(long id) {

    }
}
