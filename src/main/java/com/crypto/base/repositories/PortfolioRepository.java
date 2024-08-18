package com.crypto.base.repositories;

import com.crypto.base.entities.Portfolio;
import com.crypto.base.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
