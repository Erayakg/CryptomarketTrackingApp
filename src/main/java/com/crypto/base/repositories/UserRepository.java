package com.crypto.base.repositories;

import com.crypto.base.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(long id);
    Optional<User> findByEmail(String email);

}
