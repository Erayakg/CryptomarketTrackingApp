package com.crypto.base.dto.request;

import com.crypto.base.dto.request.CreateTransactionReq;

public record PortfolioTransactionReq (Long portfolioId, CreateTransactionReq transactionReq){
}
