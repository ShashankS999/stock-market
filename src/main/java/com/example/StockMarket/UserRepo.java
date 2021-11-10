package com.example.StockMarket;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User1,Integer>
{
	boolean existsByEmailAndPassword(String email,String password);
	boolean existsByEmail(String email);
	User1 findByEmail(String email);
}
