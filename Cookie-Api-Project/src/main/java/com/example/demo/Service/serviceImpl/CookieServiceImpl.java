package com.example.demo.Service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Service.CookieService;
import com.example.demo.dto.CookieDto;

import com.example.demo.entity.Cafe;
import com.example.demo.entity.Cookie;

import com.example.demo.exception.CafeIdNotFoundException;
import com.example.demo.exception.CookieIdNotFoundException;
import com.example.demo.exception.ServiceException;
import com.example.demo.repository.CafeRepository;
import com.example.demo.repository.CookieRepository;

@Service
public class CookieServiceImpl implements CookieService{

	ModelMapper modelMapper=new ModelMapper();
	
	@Autowired
	CookieRepository cookieRepository;
	
	
	@Autowired
	CafeRepository cafeRepository;
	
	@Override
	public CookieDto addCookies(CookieDto cookieDto,int cafeId) throws ServiceException {
		
		Boolean cafeIdSearch=false;
		try {
		cafeIdSearch=cafeRepository.existsById(cafeId);
		if(cafeIdSearch==true)
		{
			Cafe cafe= cafeRepository.findById(cafeId).get();
			Cookie cookie=convertDtoToEntity(cookieDto);
			cookie.setCafe(cafe);
			Cookie savedCookie=cookieRepository.save(cookie);
			return convertEntityToDto(savedCookie);
			
			
		}
		else {
			throw new CafeIdNotFoundException("cafe Not Found");
		}}
		catch (CafeIdNotFoundException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		
	}
	
	public CookieDto convertEntityToDto(Cookie cookie)
	{
		return modelMapper.map(cookie,CookieDto.class);

	}
	
	public Cookie convertDtoToEntity(CookieDto cookieDto)
	{
		return modelMapper.map(cookieDto,Cookie.class);
	}

	@Override
	public CookieDto searchCookie(int cookieId) throws ServiceException {
		boolean searchCookieId=false;
		try {
		searchCookieId=cookieRepository.existsById(cookieId);
		if(searchCookieId==true) {
			
			Cookie cookie=cookieRepository.findById(cookieId).get();
			CookieDto cookieDto=convertEntityToDto(cookie);
			return cookieDto;
			
		}
		else {
			throw new CookieIdNotFoundException("Invalid Cookie Id");
		}}
		catch(CookieIdNotFoundException e)
		{
			throw new ServiceException(e.getMessage(),e);
		}
		
	}

	@Override
	public CookieDto deleteCookie(int cookieId) throws ServiceException {
		boolean searchCookieId=false;
		try {
		searchCookieId=cookieRepository.existsById(cookieId);
		if(searchCookieId==true) {
			Cookie cookie=cookieRepository.findById(cookieId).get();
			cookieRepository.delete(cookie);
			CookieDto cookieDto=convertEntityToDto(cookie);
			return cookieDto;
			
		}
		else {
			throw new CookieIdNotFoundException("Invalid Cookie Id");
		}}
		catch(CookieIdNotFoundException e)
		{
			throw new ServiceException(e.getMessage(),e);
		}
		
	}

	@Override
	public List<CookieDto> getCookiebyPrice(double price) {
		
		 List<Cookie> cookieList =  cookieRepository.findAll().stream()  
                 .filter(cookie ->cookie.getPrice()>price)   // filtering price  
                 .map(cookiedata ->cookiedata)          // fetching price  
                 .collect(Collectors.toList());  
     System.out.println(cookieList); 
     List<CookieDto> cookieDtoList=cookieList.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());
		
		return cookieDtoList;
		
	}

	@Override
	public CookieDto maxPrice() {
		

		 Cookie cookie =  cookieRepository.findAll().stream()
				 .reduce(
				(a,b)->a.getPrice()>b.getPrice()?a:b).get();
		 
	CookieDto cookieDto=modelMapper.map(cookie,CookieDto.class);
	return cookieDto;
	}

	@Override
	public CookieDto searchCookieFuntionalInterface(int cookieId) throws ServiceException {
	
		
		
		try {
			Cookie cookie=cookieRepository.findById(cookieId).orElseThrow(()->new CookieIdNotFoundException("Cookie Id Not Found"));
			return modelMapper.map(cookie,CookieDto.class);
			
		
		} catch (CookieIdNotFoundException e) {
			
			throw new ServiceException(e.getMessage(),e);
		}
		
		
	
	}

	@Override
	public List<CookieDto> sortByCookie() {
		
		List<Cookie> cookieList=cookieRepository.findAllCookies(new Sort.Order(Sort.Direction.ASC,"cookieName"));
		List<CookieDto> cookieDtoList=cookieList.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());
		return cookieDtoList;
	}

	@Override
	public CookieDto getCookieIdBy3() {
		Cookie cookie=cookieRepository.getCookieById3();
		CookieDto cookieDto=modelMapper.map(cookie, CookieDto.class);
		return cookieDto;
		
	}

	@Override
	public CookieDto findByCookieName(String cookieName) {
		Cookie cookie=cookieRepository.findByCookieName(cookieName);
		CookieDto cookieDto=convertEntityToDto(cookie);
		return cookieDto;
		
	}
	

		
		
		
}
	


