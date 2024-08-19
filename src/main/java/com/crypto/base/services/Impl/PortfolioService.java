package com.crypto.base.services.Impl;

import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.PortfolioDtoReq;
import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.entities.Portfolio;
import com.crypto.base.entities.User;
import com.crypto.base.exceptions.UnauthorizedException;
import com.crypto.base.mapper.PortfolioMapper;
import com.crypto.base.repositories.PortfolioRepository;
import com.crypto.base.repositories.UserRepository;
import com.crypto.base.services.IPortfolioService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService implements IPortfolioService {

    private final PortfolioRepository portfolioRepository;

    private  final PortfolioMapper portfolioMapper;
    private final UserRepository userRepository;
    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, PortfolioMapper portfolioMapper, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
        this.userRepository = userRepository;
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
    public PortfolioDtoRes getPortfolioById(long id) {
        return null;
    }

    @Override
    public void deletePortfolio(long id) {

    }
}
