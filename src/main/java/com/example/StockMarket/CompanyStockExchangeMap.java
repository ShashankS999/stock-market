package com.example.StockMarket;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CompanyStockExchangeMap
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private StockExchange stockExchange;
	
	public CompanyStockExchangeMap() {}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Company getCompany()
	{
		return company;
	}

	public void setCompany(Company company)
	{
		this.company = company;
	}

	public StockExchange getStockExchange()
	{
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange)
	{
		this.stockExchange = stockExchange;
	}
}
