package com.example.StockMarket;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StockPriceRepo extends JpaRepository<StockPrice,Integer>
{

}
