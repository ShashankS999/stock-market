package com.example.StockMarket;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sector
{
	@Id
	@GeneratedValue
	private int id;
	
	private String sectorName;
	
	private String brief;
	
	@OneToMany(mappedBy="sector")
	private List<Company> companies=new ArrayList<>();
	
	public Sector() {}

	public Sector(String sectorName, String brief)
	{
		super();
		this.sectorName = sectorName;
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

	public String getSectorName()
	{
		return sectorName;
	}

	public void setSectorName(String sectorName)
	{
		this.sectorName = sectorName;
	}

	public String getBrief()
	{
		return brief;
	}

	public void setBrief(String brief)
	{
		this.brief = brief;
	}

	public List<Company> getCompanies()
	{
		return companies;
	}

	public void setCompanies(List<Company> companies)
	{
		this.companies = companies;
	}
}
