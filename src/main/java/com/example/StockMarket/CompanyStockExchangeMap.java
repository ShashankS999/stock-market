package com.example.StockMarket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CompanyStockExchangeMap
{
	@Id
	@GeneratedValue
	private int id;
	
	private String companyCode;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private StockExchange stockExchange;
	
	public CompanyStockExchangeMap() {}

	public CompanyStockExchangeMap(String companyCode)
	{
		super();
		this.companyCode = companyCode;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCompanyCode()
	{
		return companyCode;
	}

	public void setCompanyCode(String companyCode)
	{
		this.companyCode = companyCode;
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
