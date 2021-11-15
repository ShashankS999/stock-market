package com.example.StockMarket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepo extends JpaRepository<Sector,Integer>
{
	Sector findBySectorName(String name);
}
