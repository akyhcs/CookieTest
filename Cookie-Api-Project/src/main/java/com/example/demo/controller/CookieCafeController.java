package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Service.CafeService;
import com.example.demo.Service.CookieService;
import com.example.demo.dto.CafeDto;
import com.example.demo.dto.CookieDto;
import com.example.demo.exception.ServiceException;

@RestController
@CrossOrigin
public class CookieCafeController {
	
	
	@Autowired
	CookieService cookieService;
	
	@Autowired
	CafeService cafeService;
	
	
	@PostMapping("/add/{id}")
	public ResponseEntity<ApiResponse> addCookies(@RequestBody CookieDto cookieDto,@PathVariable("id") int cafeId) throws ServiceException{
	CookieDto savedcookieDto=cookieService.addCookies(cookieDto, cafeId);
	
	return new ResponseEntity<ApiResponse>(
			new ApiResponse("Adding Cookie.", false, savedcookieDto, HttpStatus.OK), HttpStatus.OK);

	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> DeleteCookies(@PathVariable("id") int cookieId) throws ServiceException{
		CookieDto deletecookieDto=cookieService.deleteCookie(cookieId);
		
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Delete Cookie", false, deletecookieDto, HttpStatus.OK), HttpStatus.OK);

		}
	
	
	@GetMapping("/search/{id}")
	public ResponseEntity<ApiResponse> SearchCookies(@PathVariable("id") int cookieId) throws ServiceException{
		CookieDto searchcookieDto=cookieService.searchCookie(cookieId);
		
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Search Cookie Info.", false, searchcookieDto, HttpStatus.OK), HttpStatus.OK);

		}
	
	
	@GetMapping("/getAllcafe")
	public ResponseEntity<ApiResponse> getAllCafe() {
		List<CafeDto> cafeDtoList=cafeService.getAllCafe();
		
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Search Cookie Info.", false, cafeDtoList, HttpStatus.OK), HttpStatus.OK);

		}
	
	@GetMapping("/getAllcookies/{price}")
	public ResponseEntity<ApiResponse> getAllCookieByprice(@PathVariable("price") double price) {
		
		List<CookieDto> cookieList=cookieService.getCookiebyPrice(price);
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Get Cookie Info. Filterd by Price", false, cookieList, HttpStatus.OK), HttpStatus.OK);

		
	}
	
	@GetMapping("/getcookie")
	public ResponseEntity<ApiResponse> getOneCookieByMaxPrice() {
		
		CookieDto cookie=cookieService.maxPrice();
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Get Cookie Info. Reduced by Max Price", false, cookie, HttpStatus.OK), HttpStatus.OK);

		
	}
	
	@GetMapping("/getCookieIdBy3")
	public ResponseEntity<ApiResponse> getOneCookieById3() {
		
		CookieDto cookie=cookieService.getCookieIdBy3();
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Get Cookie Info. Reduced by Max Price", false, cookie, HttpStatus.OK), HttpStatus.OK);

		
	}
	
	
	@GetMapping("/getAllcookiesbySort")
	public ResponseEntity<ApiResponse> getAllCookieBySort() {
		
		List<CookieDto> cookieList=cookieService.sortByCookie();
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Get Cookie by Sorted by Name.", false, cookieList, HttpStatus.OK), HttpStatus.OK);

		
	}
	
	@GetMapping("/getCookiebyName/{cname}")
	public ResponseEntity<ApiResponse> getOneCookieByName(@PathVariable("cname") String cookieName) {
		
		CookieDto cookie=cookieService.findByCookieName(cookieName);
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Get Cookie Info. By Name", false, cookie, HttpStatus.OK), HttpStatus.OK);

		
	}
	
}
