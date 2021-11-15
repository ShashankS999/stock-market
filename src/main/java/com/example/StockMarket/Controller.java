package com.example.StockMarket;

import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private SectorRepo secRepo;
	
	@Autowired
	private StockExchangeRepo stkRepo;
	
	@Autowired
	private StockPriceRepo prcRepo;
	
	@Autowired
	private UserRepo usrRepo;
	
	private User1 user;
	private Sector sector;
	private Company company;
	private IPO ipo;
	private StockExchange stockEx;
	CompanyStockExchangeMap map;
	
	@PostMapping("/login")
	public String login(@RequestBody User1 usr)
	{
		if(usrRepo.existsByEmailAndPassword(usr.getEmail(),usr.getPassword()))
		{
			user=usrRepo.findByEmail(usr.getEmail());
			//if(user.isConfirmed())
				return user.getRole();
			//else 
				//return null;
		}
		return null;
	}
	
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User1 usr) throws AddressException, MessagingException 
	{
		if(usrRepo.existsByEmail(usr.getEmail()))
			return false;
		usrRepo.save(usr);
		//sendEmail(usr.getId(),usr.getEmail());
		return true;
	}

	@GetMapping("/confirmUser/{userid}")
	public String welcomepage(@PathVariable Integer userid) 
	{
		user = usrRepo.getById(userid);
		user.setConfirmed(true);
		usrRepo.save(user);
		return "User confirmed" +user.getName();
	}
	
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
	
	@PostMapping("/addCompany/{sector}/{exchange}")
	public boolean addCompany(@RequestBody Company cmp, @PathVariable(value="sector") String sect, @PathVariable(value="exchange") String exchange)
	{
		String[] ex=exchange.split(",");
		if(cmpRepo.existsByCompanyName(cmp.getCompanyName()))
		{
			company=cmpRepo.findByCompanyName(cmp.getCompanyName());
			company.setBoardOfDirectors(cmp.getBoardOfDirectors());
			company.setCeo(cmp.getCeo());
			company.setCompanyBrief(cmp.getCompanyBrief());
			company.setTurnover(cmp.getTurnover());
			company.setDeactivated(false);
			cmpRepo.save(company);
			mapRepo.deleteAllByCompany(company);
			for(String e:ex)
			{
				stockEx=stkRepo.findByName(e);
				map=new CompanyStockExchangeMap();
				map.setCompany(company);
				map.setStockExchange(stockEx);
				mapRepo.save(map);
			}
			return false;
		}
		sector=secRepo.findBySectorName(sect);
		cmp.setSector(sector);
		cmpRepo.save(cmp);
		mapRepo.deleteAllByCompany(company);
		for(String e:ex)
		{
			map=new CompanyStockExchangeMap();
			stockEx=stkRepo.findByName(e);
			map.setCompany(cmp);
			map.setStockExchange(stockEx);
			mapRepo.save(map);
		}
		return true;
	}
	
	@PostMapping("/deactivateCompany")
	public boolean deactivateCompany(@RequestBody Company cmp)
	{
		if(cmpRepo.existsByCompanyName(cmp.getCompanyName()))
		{
			company=cmpRepo.findByCompanyName(cmp.getCompanyName());
			company.setDeactivated(true);
			cmpRepo.save(company);
			return true;
		}
		return false;
	}
	
	@PostMapping("/saveStockPrice/{name}")
	public boolean saveStockPrice(@RequestBody StockPrice[] stprc,@PathVariable(value="name") String name)
	{
		if(cmpRepo.existsByCompanyNameAndDeactivated(name,false))
		{
			for(StockPrice prc:stprc)
			{
				prc.setCompany(cmpRepo.findByCompanyName(name));
				prcRepo.save(prc);
			}
			return true;
		}
		return false;
	}
	
	@GetMapping("/searchCompany/{name}")
	public Company searchCompany(@PathVariable(value="name") String name)
	{
		if(cmpRepo.existsByCompanyNameAndDeactivated(name, false))
			return cmpRepo.findByCompanyName(name);
		return null;
	}
	
	@PostMapping("/updateIPO/{name}")
	public boolean updateIPO(@RequestBody IPO ip, @PathVariable(value="name") String name)
	{
		System.out.println(ip.getOpenDateTime());
		company=cmpRepo.findByCompanyName(name);
		if(ipoRepo.existsByCompany(company))
		{
			ipo=ipoRepo.findByCompany(company);
			ipo.setOpenDateTime(ip.getOpenDateTime());
			ipo.setPricePerShare(ip.getPricePerShare());
			ipo.setTotalShares(ip.getTotalShares());
			ipoRepo.save(ipo);
			return false;
		}
		ip.setCompany(company);
		ipoRepo.save(ip);
		return true;
	}
	
	@GetMapping("/sharesByCompanyName/{name}")
	public List<StockPrice> sharesByCompanyName(@PathVariable(value="name") String name)
	{
		if(cmpRepo.existsByCompanyName(name))
		{
			company=cmpRepo.findByCompanyName(name);
			return prcRepo.findByCompany(company);
		}
		return null;
	}
	
	public void sendEmail(Integer userId,String email) throws AddressException, MessagingException 
	{
		final String username = "automailnoreply0@gmail.com";
		final String password = "Some0Password";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");  //Port for SSL: 465,Port for TLS/STARTTLS: 587
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(prop,new javax.mail.Authenticator() 
		{
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
			{
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});
		try 
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("automailnoreply0@gmail.com"));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(email)
					);
			message.setSubject("User confirmation mail");
			message.setContent("<h1><a href =\"http://127.0.0.1:8080/confirmUser/"+userId+"/\"> Click to confirm </a></h1>","text/html");
			Transport.send(message);
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}
}
