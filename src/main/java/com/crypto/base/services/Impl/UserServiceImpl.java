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
import com.crypto.base.exceptions.UnauthorizedException;
import com.crypto.base.mapper.UserMapper;
import com.crypto.base.repositories.UserRepository;
import com.crypto.base.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDtoRes createUser(SaveUserReq user) {

        try {
            User saveUser = userMapper.toEntity(user);

            if (saveUser.getRoleEnum().getTypeInt() == 1) {
                throw new AdminSaveError(UserErrorMessage.USER_NOT_ADMIN);
            }

            saveUser.setPassword(passwordEncoder.encode(saveUser.getPassword()));
            User save = userRepository.save(saveUser);

            return userMapper.toDto(save);

        } catch (Exception e) {
            throw new BusinessException(UserErrorMessage.USER_SAVE_FAILED);
        }
    }

    @Override
    public UserDtoRes updateUser(SaveUserReq user, Long id) {

        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> byUsername = userRepository.findByUsername(authenticatedUsername);

        User userById = userRepository.findById(id)
                .orElseThrow(() -> new NotfoundException(UserErrorMessage.NOT_FOUND));

        if (userById.getUsername().equals(authenticatedUsername) || byUsername.get().getRoleEnum().getTypeInt().equals(1)) {

            User entity = userMapper.toEntity(user);

            if (entity.getRoleEnum().getTypeInt() == 1) {
                throw new AdminSaveError(UserErrorMessage.USER_NOT_ADMIN);
            }

            entity.setId(id);
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            entity.setUsername(userById.getUsername());
            User save = userRepository.save(entity);

            return userMapper.toDto(save);
        }else {
            throw new UnauthorizedException(UserErrorMessage.USER_NOT_AUTHORITY);
        }
    }

    @Override
    public void deleteUser(Long id) {

        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> byUsername = userRepository.findByUsername(authenticatedUsername);

        User userById = userRepository.findById(id)
                .orElseThrow(() -> new NotfoundException(UserErrorMessage.NOT_FOUND));

        if (byUsername.get().getRoleEnum().getTypeInt() == 1 || userById.getUsername().equals(authenticatedUsername) ) {
            userRepository.delete(userById);
        }
        else {
            throw new UnauthorizedException(UserErrorMessage.USER_NOT_AUTHORITY);
        }

    }
    @Override
    public UserDtoRes getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new NotfoundException(UserErrorMessage.NOT_FOUND));

        return userMapper.toDto(user);

    }

    @Override
    public List<UserDtoRes> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDtoRes addPortfolio(Long userID, Long portfolioID) {
        return null;
    }

    @Override
    public void removePortfolio(Long userID, Long portfolioID) {

    }


}
