package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investor.models.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {

}
