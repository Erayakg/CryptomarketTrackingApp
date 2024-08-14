package com.crypto.base.services;

import com.crypto.base.dto.CreatePortfolioDto;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserDtoRes;

import java.util.List;

public interface IUserService {

    UserDtoRes createUser(SaveUserReq user);

    UserDtoRes updateUser(SaveUserReq user, Long id);

    void deleteUser(Long id);

    UserDtoRes getUserById(Long id);

    List<UserDtoRes> getAllUsers();

    UserDtoRes addPortfolio(Long userID, Long portfolioID);

    void removePortfolio(Long userID, Long portfolioID);


}
