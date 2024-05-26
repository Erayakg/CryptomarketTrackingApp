package com.crypto.base.services;

import com.crypto.base.dto.request.PortfolioTransactionReq;

public interface IPortfolioService {

    void updatePortfolio(PortfolioTransactionReq transactionReq);
}
