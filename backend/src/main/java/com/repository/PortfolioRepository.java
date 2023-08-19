package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.models.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer>{
	
	List<Portfolio> findByMutualFundId(@Param("mutualFundId") int mutualFundId);
	
	@Query("SELECT p.stockUnits FROM Portfolio p " + "WHERE p.stockId = :stockId")
	Double findStockUnitsByStockId(@Param("stockId") int stockId);

}
