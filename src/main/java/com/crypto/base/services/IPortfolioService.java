package com.crypto.base.services;


import com.crypto.base.dto.PortfolioDtoReq;
import com.crypto.base.dto.PortfolioDtoRes;

import java.util.List;

public interface IPortfolioService {

    PortfolioDtoRes updatePortfolio(PortfolioDtoReq portfolioDtoReq);

    List<PortfolioDtoRes> getAllPortfolio();

    PortfolioDtoRes createPortfolio(Long id,PortfolioDtoReq  portfolioDtoReq);

    PortfolioDtoRes getPortfolioById(long id);

    void deletePortfolio(long id);


}
