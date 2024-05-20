package com.crypto.base.services.Impl;

import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.CreatePortfolioDto;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserResDto;
import com.crypto.base.entities.User;
import com.crypto.base.exceptions.AdminSaveError;
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
        if (saveUser.getRoleEnum().getTypeInt() == 1) {
            throw new AdminSaveError(UserErrorMessage.USER_NOT_ADMIN);
        }
        try {
            userRepository.save(saveUser);
        } catch (Exception e) {
            throw new BusinessException(UserErrorMessage.USER_SAVE_FAILED);
        }
    }

    @Override
    public void updateUser(SaveUserReq saveUserReq, Long id) {

        User userGet = userRepository.getUserById(id);
        if (userGet == null)
            throw new NotfoundException(UserErrorMessage.NOT_FOUND);
        try {
            userGet.setAbout(saveUserReq.getAbout());
            userGet.setEmail(saveUserReq.getEmail());
            userGet.setName(saveUserReq.getName());
            userGet.setPassword(saveUserReq.getPassword());
            userGet.setProfilePhoto(saveUserReq.getProfilePhoto());
            userGet.setCountry(saveUserReq.getCountry());
            userGet.setSurName(saveUserReq.getSurName());
            userRepository.save(userGet);
        } catch (Exception e) {
            throw new BusinessException(UserErrorMessage.USER_UPDATE_FAILED);
        }
    }

    @Override
    public void deleteUser(Long id) {
        User userGet = userRepository.getUserById(id);
        if (userGet == null)
            throw new NotfoundException(UserErrorMessage.NOT_FOUND);
        try {
            userRepository.delete(userGet);
        }catch (Exception e){
            throw  new BusinessException(UserErrorMessage.USER_DELETE_FAILED);
        }
    }

    @Override
    public UserResDto getUserById(Long id) {
        User userGet = userRepository.getUserById(id);
        if (userGet == null)
            throw new NotfoundException(UserErrorMessage.NOT_FOUND);

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
    public UserResDto mapUserToUserResDto(User user) {
      return  null;
    }
}
