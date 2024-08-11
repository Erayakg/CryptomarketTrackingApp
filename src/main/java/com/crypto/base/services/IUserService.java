package com.crypto.base.services;

import com.crypto.base.dto.CreatePortfolioDto;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserDtoRes;

import java.util.List;

public interface IUserService {

    UserDtoRes saveUser(SaveUserReq user);

    void updateUser(SaveUserReq user, Long id);

    void deleteUser(Long id);

    UserDtoRes getUserById(Long id);

    List<UserDtoRes> getAllUsers();

    UserDtoRes createPortfolio(Long userId, CreatePortfolioDto portfolioDto);

    UserDtoRes addPortfolio(Long userID, Long portfolioID);

    UserDtoRes removePortfolio(Long userID, Long portfolioID);

}
