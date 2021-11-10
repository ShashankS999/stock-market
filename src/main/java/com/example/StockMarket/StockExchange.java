package com.example.StockMarket;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StockExchange
{
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String brief;
	
	@OneToMany(targetEntity=CompanyStockExchangeMap.class,mappedBy="stockExchange")
	private List<CompanyStockExchangeMap> compstockmap=new ArrayList<>();
	
	public StockExchange() {}

	public StockExchange(String name, String brief)
	{
		super();
		this.name = name;
		this.brief = brief;
	}

	public String getBrief()
	{
		return brief;
	}

	public void setBrief(String brief)
	{
		this.brief = brief;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<CompanyStockExchangeMap> getCompstockmap()
	{
		return compstockmap;
	}

	public void setCompstockmap(List<CompanyStockExchangeMap> compstockmap)
	{
		this.compstockmap = compstockmap;
	}
}
