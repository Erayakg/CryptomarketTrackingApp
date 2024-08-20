package com.crypto.base.services;

import com.crypto.base.dto.PortfolioDtoReq;
import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserDtoRes;

import java.util.List;

public interface IUserService {

    UserDtoRes createUser(SaveUserReq user);

    UserDtoRes updateUser(SaveUserReq user, Long id);

    void deleteUser(Long id);

    UserDtoRes getUserById(Long id);

    List<UserDtoRes> getAllUsers();

    UserDtoRes CreatePortfolio(PortfolioDtoReq portfolioDtoReq);

    UserDtoRes addPortfolio(Long Userid, Long PortfolioId );

    void removePortfolio(Long userID, Long portfolioID);


}
