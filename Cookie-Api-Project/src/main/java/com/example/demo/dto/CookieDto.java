package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CookieDto {
	
	private int cookieId;
	
	private String cookieName;
	
	private double price;
	
	@JsonIgnoreProperties("cookies")
	private CafeDto cafe;
	
	

	public CookieDto() {
		super();
	}

	public CookieDto(int cookieId, String cookieName, double price, CafeDto cafe) {
		super();
		this.cookieId = cookieId;
		this.cookieName = cookieName;
		this.price = price;
		this.cafe = cafe;
	}

	public int getCookieId() {
		return cookieId;
	}

	public void setCookieId(int cookieId) {
		this.cookieId = cookieId;
	}

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CafeDto getCafe() {
		return cafe;
	}

	public void setCafe(CafeDto cafe) {
		this.cafe = cafe;
	}
	
	
	

}
