package com.crypto.base.services.Impl;

import com.crypto.base.constant.PortfolioErrorMessage;
import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.PortfolioDtoReq;
import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.entities.Portfolio;
import com.crypto.base.entities.User;
import com.crypto.base.exceptions.NotfoundException;
import com.crypto.base.exceptions.UnauthorizedException;
import com.crypto.base.mapper.PortfolioMapper;
import com.crypto.base.repositories.PortfolioRepository;
import com.crypto.base.repositories.UserRepository;
import com.crypto.base.services.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService implements IPortfolioService {

    private final PortfolioRepository portfolioRepository;

    private final PortfolioMapper portfolioMapper;
    private final UserRepository userRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, PortfolioMapper portfolioMapper, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
        this.userRepository = userRepository;
    }

    @Override
    public PortfolioDtoRes updatePortfolio(PortfolioDtoReq portfolioDtoReq, long portfolioId) {

        String authentication = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> userOptional = userRepository.findByUsername(authentication);

        if (userOptional.isEmpty()) {
            throw new NotfoundException(UserErrorMessage.NOT_FOUND);
        }
        User user = userOptional.get();

        if (user.getRoleEnum().getTypeInt().equals(2)) {
            throw new UnauthorizedException(UserErrorMessage.USER_NOT_AUTHORITY_UPDATE_PORTFOLIO);
        }

        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(portfolioId);

        if (portfolioOptional.isEmpty()) {

            throw new NotfoundException(PortfolioErrorMessage.NOT_FOUND_EXCEPTIONS);
        }
        Portfolio portfolio = portfolioOptional.get();

        if (!user.getPortfolios().contains(portfolio)) {
            throw new UnauthorizedException(UserErrorMessage.USER_NOT_AUTHORITY);
        }

        portfolio.setName(portfolioDtoReq.name());
        portfolio.setDescription(portfolioDtoReq.description());

        Portfolio updatedPortfolio = portfolioRepository.save(portfolio);

        return portfolioMapper.toDto(updatedPortfolio);
    }

    @Override
    public List<PortfolioDtoRes> getAllPortfolio() {
        List<Portfolio> portfolios = portfolioRepository.findAll();
        List<PortfolioDtoRes> portfolioDtoResList = new ArrayList<>();
        portfolios.forEach(portfolio -> {
            portfolioDtoResList.add(portfolioMapper.toDto(portfolio));
        });
        return portfolioDtoResList;
    }

    @Override
    public PortfolioDtoRes getPortfolioById(long id) {

        Optional<Portfolio> byId = portfolioRepository.findById(id);

        if (byId.isEmpty()) {
            throw new NotfoundException(PortfolioErrorMessage.NOT_FOUND_EXCEPTIONS);
        }
        return portfolioMapper.toDto(byId.get());
    }

    @Override
    public void deletePortfolio(long id) {


    }
}
