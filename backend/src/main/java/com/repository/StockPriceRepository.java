package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utilities.models.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {

	@Query("SELECT sp FROM StockPrice sp "
			+ "WHERE TO_CHAR(sp.businessDate, 'yyyy-MM-dd') = FUNCTION('TO_CHAR', CURRENT_DATE, 'yyyy-MM-dd')")
	List<StockPrice> findStocksAndPrices();

	@Query("SELECT sp.openingPrice FROM StockPrice sp " + "WHERE sp.stockId = :stockId "
			+ "AND TO_CHAR(sp.businessDate, 'yyyy-MM-dd') = FUNCTION('TO_CHAR', CURRENT_DATE, 'yyyy-MM-dd')")
	Double findOpeningPricesByStockId(@Param("stockId") int stockId);



}
