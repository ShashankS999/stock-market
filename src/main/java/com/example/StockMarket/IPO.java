package com.example.StockMarket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class IPO
{
	@Id
	@GeneratedValue
	private int id;
	
	private double pricePerShare;
	
	private int totalShares;
	
	private LocalDateTime openDateTime;
	
	@OneToOne
	private Company company;
	
	@ManyToMany
	private List<StockExchange> stockExchanges=new ArrayList<>();
	
	public IPO() {}

	public IPO(double pricePerShare, int totalShares, LocalDateTime openDateTime)
	{
		super();
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.openDateTime = openDateTime;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double getPricePerShare()
	{
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare)
	{
		this.pricePerShare = pricePerShare;
	}

	public int getTotalShares()
	{
		return totalShares;
	}

	public void setTotalShares(int totalShares)
	{
		this.totalShares = totalShares;
	}

	public LocalDateTime getOpenDateTime()
	{
		return openDateTime;
	}

	public void setOpenDateTime(LocalDateTime openDateTime)
	{
		this.openDateTime = openDateTime;
	}

	public Company getCompany()
	{
		return company;
	}

	public void setCompany(Company company)
	{
		this.company = company;
	}

	public List<StockExchange> getStockExchanges()
	{
		return stockExchanges;
	}

	public void setStockExchanges(List<StockExchange> stockExchanges)
	{
		this.stockExchanges = stockExchanges;
	}
}
