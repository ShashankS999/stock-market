package com.example.StockMarket;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StockPriceRepo extends JpaRepository<StockPrice,Integer>
{
	List<StockPrice> findByCompany(Company company);
}
