package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utilities.models.NavHistory;

@Repository
public interface NavHistoryRepository extends JpaRepository<NavHistory, Integer> {
	
	@Query("SELECT nh FROM NavHistory nh WHERE nh.mutualFundId = :mutualFundId AND nh.businessDate = (SELECT MAX(nh2.businessDate) FROM NavHistory nh2 WHERE nh2.mutualFundId = :mutualFundId AND nh2.businessDate < CURRENT_DATE)")
    NavHistory findPreviousNavHistoryByMfId(@Param("mutualFundId") int mutualFundId);
}
