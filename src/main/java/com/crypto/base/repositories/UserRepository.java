package com.crypto.base.repositories;

import com.crypto.base.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(long id);

}
