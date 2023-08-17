package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.models.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer>{

}
