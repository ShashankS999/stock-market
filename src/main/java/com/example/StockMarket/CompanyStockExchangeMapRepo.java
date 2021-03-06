package com.example.StockMarket;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CompanyStockExchangeMapRepo extends JpaRepository<CompanyStockExchangeMap,Integer>
{
	void deleteAllByCompany(Company company);
}
