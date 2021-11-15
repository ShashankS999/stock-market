package com.example.StockMarket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPORepo extends JpaRepository<IPO,Integer>
{
	boolean existsByCompany(Company cmp);
	IPO findByCompany(Company cmp);
}
