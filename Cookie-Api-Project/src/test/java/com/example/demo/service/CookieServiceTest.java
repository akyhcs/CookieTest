package com.example.demo.service;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Service.CookieService;
import com.example.demo.Service.serviceImpl.CookieServiceImpl;
import com.example.demo.dto.CookieDto;
import com.example.demo.entity.Cafe;
import com.example.demo.entity.Cookie;
import com.example.demo.exception.CafeIdNotFoundException;
import com.example.demo.exception.ServiceException;
import com.example.demo.repository.CafeRepository;
import com.example.demo.repository.CookieRepository;

@RunWith(SpringRunner.class)
public class CookieServiceTest {
	
	@TestConfiguration
	static class CookieServiceTestConfiguration{
		@Bean
		public CookieService cookieService() {
			return new CookieServiceImpl();
		}
		
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}
	}
	
	@Autowired
	CookieService cookieService;
	
	@MockBean
	CookieRepository cookieRepository;
	
	@MockBean
	CafeRepository cafeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	private Cookie cookie;
	private Cafe cafe;
	
	@org.junit.Before
	public void setup() {
		
		Cookie cookie =new Cookie();
		cookie.setCookieName("Choco Chips Cookie");
		cookie.setPrice(100);
		
		
		
		
	}
	
	
	/*Boolean cafeIdSearch=false;
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
	}*/
	
//	@Test
//	public CookieDto addCookies(CookieDto cookieDto,int cafeId) throws ServiceException{
//		//cafeRepository.existsById(cafeId).get();
//		
//		Cookie cookie = modelMapper.map(cookieDto,Cookie.class);
//		Mockito.when(cookieRepository.save(cookie)).thenReturn(cookie);
//		Optional<Cafe> cafe1=Optional.of(cafe);
//		Mockito.when(cafeRepository.findById(cafeId)).thenReturn(cafe1);
//		
//		
//	}
//	

}
