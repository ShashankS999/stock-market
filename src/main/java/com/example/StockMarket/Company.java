package com.example.StockMarket;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company 
{
	@Id
	@GeneratedValue
	private Integer id;
	
	private String companyName;
	
	private Double turnover;
	
	private String ceo;
	
	private String boardOfDirectors;
	
	private String companyBrief;
	
	private boolean deactivated;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy="company",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private IPO ipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Sector sector;
	
	public Company() 
	{
		this.setDeactivated(false);
	}

	public Company(String companyName, Double turnover, String ceo, String boardOfDirectors, String companyBrief)
	{
		super();
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.companyBrief = companyBrief;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public Double getTurnover()
	{
		return turnover;
	}

	public void setTurnover(Double turnover)
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

	public boolean isDeactivated()
	{
		return deactivated;
	}

	public void setDeactivated(boolean deactivated)
	{
		this.deactivated = deactivated;
	}

	public IPO getIpo()
	{
		return ipo;
	}

	public void setIpo(IPO ipo)
	{
		this.ipo = ipo;
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