package com.crypto.base.services.Impl;

import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.request.CreatePortfolioDto;
import com.crypto.base.dto.request.SaveUserReq;
import com.crypto.base.dto.response.UserResDto;
import com.crypto.base.entities.User;
import com.crypto.base.exceptions.BusinessException;
import com.crypto.base.exceptions.NotfoundException;
import com.crypto.base.repositories.UserRepository;
import com.crypto.base.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(SaveUserReq user) {
        User saveUser = mapReqToUser(user);
        try {
            userRepository.save(saveUser);
        }catch (Exception e){
            throw new BusinessException(UserErrorMessage.USER_SAVE_FAILED);
        }
    }

    @Override
    public void updateUser(SaveUserReq user, Long id) {

        try {

            User userGet= userRepository.getUserById(id);
            if (userGet == null)
                throw new NotfoundException(UserErrorMessage.NOT_FOUND);
              //tamamla
        }
        catch (Exception e){
            throw  new BusinessException(UserErrorMessage.USER_UPDATE_FAILED);
        }
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserResDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserResDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResDto createPortfolio(Long userId, CreatePortfolioDto portfolioDto) {
        return null;
    }

    @Override
    public UserResDto addPortfolio(Long userID, Long portfolioID) {
        return null;
    }

    @Override
    public UserResDto removePortfolio(Long userID, Long portfolioID) {
        return null;
    }

    @Override
    public UserResDto updatePortfolio(Long userID, Long portfolioID, Long newPortfolioID) {
        return null;
    }

    public User mapReqToUser(SaveUserReq saveUserReq) {
        User user = new User();
        user.setAbout(saveUserReq.getAbout());
        user.setEmail(saveUserReq.getEmail());
        user.setName(saveUserReq.getName());
        user.setPassword(saveUserReq.getPassword());
        user.setRoleEnum(saveUserReq.getRoleEnum());
        user.setProfilePhoto(saveUserReq.getProfilePhoto());
        user.setCountry(saveUserReq.getCountry());
        user.setSurName(saveUserReq.getSurName());

        return user;

    }
}
