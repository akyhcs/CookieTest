package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cookie;


@Repository
public interface CookieRepository extends JpaRepository<Cookie, Integer>{

	
	@Query("select cookie from Cookie cookie where cookie.cookieId=3")
	public Cookie getCookieById3();
	
	@Query(value="select * from Cookie cookie where cookie.cookieId=3",nativeQuery=true)
	public Cookie getCookieById3Native();
	
	@Query(value="Select cookieData from Cookie cookieData")
	List<Cookie> findAllCookies(Order order);
	
	@Query("select cookeys from Cookie cookeys where cookeys.cookieName=?1")
	public Cookie findByCookieName(String cookieName);
		
	
}
