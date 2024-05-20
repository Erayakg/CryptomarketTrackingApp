package com.crypto.base.services;

import com.crypto.base.dto.CreatePortfolioDto;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserResDto;

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

}
