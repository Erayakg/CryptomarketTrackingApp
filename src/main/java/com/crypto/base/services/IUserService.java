package com.crypto.base.services;

import com.crypto.base.dto.request.CreatePortfolioDto;
import com.crypto.base.dto.request.SaveUserReq;
import com.crypto.base.dto.response.UserResDto;

import java.util.List;

public interface IUserService {

    void saveUser(SaveUserReq user);

    void updateUser(SaveUserReq user, Long id);

    void deleteUser(Long id);

    UserResDto getUserById(Long id);

    List<UserResDto> getAllUsers();

    UserResDto createPortfolio(Long userId, CreatePortfolioDto portfolioDto);

    UserResDto addPortfolio(Long userID, Long portfolioID);

    UserResDto removePortfolio(Long userID, Long portfolioID);

    UserResDto updatePortfolio(Long userID, Long portfolioID, Long newPortfolioID);


}
