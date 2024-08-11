package com.crypto.base.services;

import com.crypto.base.dto.CreatePortfolioDto;
import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.dto.PortfolioTransactionReq;

import java.util.List;

public interface IPortfolioService {

    void updatePortfolio(PortfolioTransactionReq transactionReq);

    List<PortfolioDtoRes> getAllPortfolio();

    PortfolioDtoRes createPortfolio(CreatePortfolioDto createPortfolioDto);

    PortfolioDtoRes getPortfolioById(long id);

    void deletePortfolio(long id);


}
