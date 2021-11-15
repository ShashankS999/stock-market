package com.example.StockMarket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockExchange
{
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String brief;
	
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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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
}
