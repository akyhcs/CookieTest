package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.CookieDto;
import com.example.demo.exception.ServiceException;

public interface CookieService {
	
	public CookieDto addCookies(CookieDto cookieDto,int cafeId) throws ServiceException;
	
	public CookieDto searchCookie(int cookieId) throws ServiceException;
	
	public CookieDto searchCookieFuntionalInterface(int cookieId) throws ServiceException;
	
	public CookieDto deleteCookie(int cookieId) throws ServiceException;
	
	public List<CookieDto> getCookiebyPrice(double price);
	
	public List<CookieDto> sortByCookie();
	
	
	public CookieDto getCookieIdBy3();
	
	public CookieDto maxPrice();
	
	public CookieDto findByCookieName(String cookieName);
	
	

}
