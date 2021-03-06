package com.example.StockMarket;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CompanyRepo extends JpaRepository<Company,Integer>
{
	boolean existsByCompanyName(String name);
	boolean existsByCompanyNameAndDeactivated(String name,boolean value);
	void deleteByCompanyName(String name);
	Company findByCompanyName(String name);
	Company findByCompanyNameAndDeactivated(String name,boolean value);
}
