package com.crypto.base.services;


import com.crypto.base.dto.PortfolioDtoReq;
import com.crypto.base.dto.PortfolioDtoRes;

import java.util.List;

public interface IPortfolioService {

    PortfolioDtoRes updatePortfolio(PortfolioDtoReq portfolioDtoReq,long id);

    List<PortfolioDtoRes> getAllPortfolio();

    PortfolioDtoRes getPortfolioById(long id);

    void deletePortfolio(long id);



}
