package com.example.StockMarket;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StockPrice
{
	@Id
	@GeneratedValue
	private int id;
	
	private String exchangeName;
	
	private String companyCode;
	
	@ManyToOne
	private Company company;
	
	private Date date;
	
	private Time time;
	
	private double sharePrice;
	
	public StockPrice() {}

	public StockPrice(String exchangeName, String companyCode, Date date, Time time, double sharePrice)
	{
		super();
		this.exchangeName = exchangeName;
		this.companyCode = companyCode;
		this.date = date;
		this.time = time;
		this.sharePrice = sharePrice;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getExchangeName()
	{
		return exchangeName;
	}

	public void setExchangeName(String exchangeName)
	{
		this.exchangeName = exchangeName;
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

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Time getTime()
	{
		return time;
	}

	public void setTime(Time time)
	{
		this.time = time;
	}

	public double getSharePrice()
	{
		return sharePrice;
	}

	public void setSharePrice(double sharePrice)
	{
		this.sharePrice = sharePrice;
	}
}
