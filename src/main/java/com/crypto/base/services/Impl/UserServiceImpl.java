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
import com.crypto.base.repositories.UserRepository;
import com.crypto.base.services.IUserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<User> userList = userRepository.findAll();
        return userList.stream().map(this::mapToUserResDto).collect(Collectors.toList());
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


    private UserResDto mapToUserResDto(User user) {
        Set<PortfolioDto> portfolioDtos = user.getPortfolios().stream()
                .map(this::mapToPortfolioDto)
                .collect(Collectors.toSet());

        Set<NotificationDto> notificationDtos = user.getNotifications().stream()
                .map(this::mapToNotificationDto)
                .collect(Collectors.toSet());

        return new UserResDto(
                user.getCreateDate(),
                user.getUpdateDate(),
                user.getCreatedBy(),
                user.getUpdatedBy(),
                user.getName(),
                user.getSurName(),
                user.getEmail(),
                user.getProfilePhoto(),
                user.getAbout(),
                user.getCountry(),
                portfolioDtos,
                notificationDtos,
                user.getRoleEnum().getTypeString()
        );
    }

    private PortfolioDto mapToPortfolioDto(Portfolio portfolio) {
        Set<TransactionDto> transactionDtos = portfolio.getTransactions().stream()
                .map(this::mapToTransactionDto)
                .collect(Collectors.toSet());

        return new PortfolioDto(
                portfolio.getCreateDate(),
                portfolio.getUpdateDate(),
                portfolio.getCreatedBy(),
                portfolio.getUpdatedBy(),
                portfolio.getId(),
                portfolio.getName(),
                portfolio.getDescription(),
                transactionDtos
        );
    }

    private NotificationDto mapToNotificationDto(Notification notification) {
        return new NotificationDto(
                notification.getCreateDate(),
                notification.getUpdateDate(),
                notification.getCreatedBy(),
                notification.getUpdatedBy(),
                notification.getId(),
                notification.getText(),
                notification.getTitle()
        );
    }

    private TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getCreateDate(),
                transaction.getUpdateDate(),
                transaction.getCreatedBy(),
                transaction.getUpdatedBy(),
                transaction.getId(),
                transaction.getIsActiveEnum(),
                transaction.getSalePrice(),
                transaction.getPurchasePrice(),
                transaction.getAmount(),
                transaction.getTokenId()
        );
    }


    public UserResDto mapUserToUserResDto(User user) {
      return  null;
    }
}
