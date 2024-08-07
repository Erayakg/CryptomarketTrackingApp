package com.crypto.base.services;

import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.dto.PortfolioTransactionReq;
import com.crypto.base.dto.RestResponse;

import java.util.List;

public interface IPortfolioService {

    void updatePortfolio(PortfolioTransactionReq transactionReq);
    List<PortfolioDtoRes> getAllPortfolio();

}
