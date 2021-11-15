package com.example.StockMarket;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class IPO
{
	@Id
	@GeneratedValue
	private Integer id;
	
	private Double pricePerShare;
	
	private Integer totalShares;
	
	private Date openDateTime;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Company company;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<StockExchange> stockExchanges=new ArrayList<>();
	
	public IPO() {}

	public IPO(Double pricePerShare, Integer totalShares, Date openDateTime)
	{
		super();
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.openDateTime = openDateTime;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Double getPricePerShare()
	{
		return pricePerShare;
	}

	public void setPricePerShare(Double pricePerShare)
	{
		this.pricePerShare = pricePerShare;
	}

	public Integer getTotalShares()
	{
		return totalShares;
	}

	public void setTotalShares(Integer totalShares)
	{
		this.totalShares = totalShares;
	}

	public Date getOpenDateTime()
	{
		return openDateTime;
	}

	public void setOpenDateTime(Date openDateTime)
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
