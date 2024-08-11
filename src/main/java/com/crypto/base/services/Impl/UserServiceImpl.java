package com.crypto.base.services.Impl;

import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.*;
import com.crypto.base.entities.Notification;
import com.crypto.base.entities.Portfolio;
import com.crypto.base.entities.Transaction;
import com.crypto.base.entities.User;
import com.crypto.base.exceptions.AdminSaveError;
import com.crypto.base.exceptions.BusinessException;
import com.crypto.base.exceptions.NotfoundException;
import com.crypto.base.mapper.UserMapper;
import com.crypto.base.repositories.UserRepository;
import com.crypto.base.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDtoRes saveUser(SaveUserReq user) {

        User saveUser = userMapper.toEntity(user);

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
    public UserDtoRes getUserById(Long id) {
        User userGet = userRepository.getUserById(id);
        if (userGet == null)
            throw new NotfoundException(UserErrorMessage.NOT_FOUND);

        return null;
    }
    @Override
    public List<UserDtoRes> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(this::mapToUserResDto).collect(Collectors.toList());
    }

    @Override
    public UserDtoRes createPortfolio(Long userId, CreatePortfolioDto portfolioDto) {
        return null;
    }

    @Override
    public UserDtoRes addPortfolio(Long userID, Long portfolioID) {
        return null;
    }

    @Override
    public UserDtoRes removePortfolio(Long userID, Long portfolioID) {
        return null;
    }


}
