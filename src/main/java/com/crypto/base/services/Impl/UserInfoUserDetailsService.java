package com.crypto.base.services.Impl;

import com.crypto.base.config.UserDetail;
import com.crypto.base.entities.User;
import com.crypto.base.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userInfo = userRepository.findByUsername(userName);
        return userInfo.map(UserDetail::new).
                orElseThrow(() -> new UsernameNotFoundException("user not found" + userName));
    }
}