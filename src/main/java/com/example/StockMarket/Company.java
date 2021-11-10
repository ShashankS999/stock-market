package com.example.StockMarket;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Company 
{
	@Id
	@GeneratedValue
	private int id;
	
	private String companyName;
	
	private double turnover;
	
	private String ceo;
	
	private String boardOfDirectors;
	
	private String companyBrief;
	
	@OneToOne(mappedBy="company",cascade=CascadeType.REMOVE)
	private IPO ipo;
	
	@OneToMany(targetEntity=CompanyStockExchangeMap.class,mappedBy="company")
	private List<CompanyStockExchangeMap> compstockmap=new ArrayList<>();
	
	@ManyToOne
	private Sector sector;
	
	public Company() {}

	public Company(String companyName, double turnover, String ceo, String boardOfDirectors, String companyBrief)
	{
		super();
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.companyBrief = companyBrief;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public double getTurnover()
	{
		return turnover;
	}

	public void setTurnover(double turnover)
	{
		this.turnover = turnover;
	}

	public String getCeo()
	{
		return ceo;
	}

	public void setCeo(String ceo)
	{
		this.ceo = ceo;
	}

	public String getBoardOfDirectors()
	{
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors)
	{
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getCompanyBrief()
	{
		return companyBrief;
	}

	public void setCompanyBrief(String companyBrief)
	{
		this.companyBrief = companyBrief;
	}

	public IPO getIpo()
	{
		return ipo;
	}

	public void setIpo(IPO ipo)
	{
		this.ipo = ipo;
	}

	public List<CompanyStockExchangeMap> getCompstockmap()
	{
		return compstockmap;
	}

	public void setCompstockmap(List<CompanyStockExchangeMap> compstockmap)
	{
		this.compstockmap = compstockmap;
	}

	public Sector getSector()
	{
		return sector;
	}

	public void setSector(Sector sector)
	{
		this.sector = sector;
	}
}
