package com.example.StockMarket;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@CrossOrigin
public class Controller
{
	@Autowired
	private CompanyRepo cmpRepo;
	
	@Autowired
	private CompanyStockExchangeMapRepo mapRepo;
	
	@Autowired
	private IPORepo ipoRepo;
	
	@Autowired
	private StockExchangeRepo stkRepo;
	
	@Autowired
	private StockPriceRepo prcRepo;
	
	@Autowired
	private UserRepo usrRepo;
	
	private User1 user;
	
	@GetMapping("/listStockExchange")
	public List<StockExchange> listStockExchange()
	{
		return stkRepo.findAll();
	}
	
	@PostMapping("/addStockExchange")
	public boolean addStockExchange(@RequestBody StockExchange se)
	{
		if(stkRepo.existsByName(se.getName()))
			return false;
		stkRepo.save(se);
		return true;
	}
	
	@PostMapping("/addCompany")
	public boolean addCompany(@RequestBody Company cmp)
	{
		if(cmpRepo.existsByCompanyName(cmp.getCompanyName()))
			return false;
		cmpRepo.save(cmp);
		return true;
	}
	
	@DeleteMapping("/deleteCompany")
	public boolean deleteCompany(@RequestBody Company cmp)
	{
		if(cmpRepo.existsByCompanyName(cmp.getCompanyName()))
		{
			cmpRepo.deleteByCompanyName(cmp.getCompanyName());
			return true;
		}
		return false;
	}
	
	@PostMapping("/updateIPO")
	public void updateIPO(@RequestBody IPO ipo)
	{
		ipoRepo.save(ipo);
	}
	
	@PostMapping("/addStockPrice")
	public void addStockPrice(@RequestBody StockPrice prc)
	{
		prcRepo.save(prc);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User1 usr)
	{
		if(usrRepo.existsByEmailAndPassword(usr.getEmail(),usr.getPassword()))
		{
			user=usrRepo.findByEmail(usr.getEmail());
			return user.getRole();
		}
		return null;
	}
	
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User1 usr)
	{
		if(usrRepo.existsByEmail(usr.getEmail()))
			return false;
		usrRepo.save(usr);
		return true;
	}
	
	@PostMapping("/searchCompany")
	public Company searchCompany(@RequestBody String name)
	{
		if(cmpRepo.existsByCompanyName(name))
			return cmpRepo.findByCompanyName(name);
		else
			return null;
	}
}
