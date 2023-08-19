package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.models.MutualFund;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, Integer> {

	@Query("SELECT sp.openingPrice FROM StockPrice sp "
			+ "WHERE sp.stockId = :stockId AND TO_CHAR(sp.businessDate, 'yyyy-MM-dd') = FUNCTION('TO_CHAR', CURRENT_DATE, 'yyyy-MM-dd')")
	Double findOpeningPriceByStockIdAndBusinessDate(@Param("stockId") int stockId);
}
