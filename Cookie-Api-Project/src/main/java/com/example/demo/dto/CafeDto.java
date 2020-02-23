package com.example.demo.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CafeDto {
	
	private int cafe;

	private String cafeName;
	
	@JsonIgnoreProperties("cafe")
	private List<CookieDto> cookies;
	
	
	

	public CafeDto() {
		super();
	}

	public CafeDto(int cafe, String cafeName, List<CookieDto> cookies) {
		super();
		this.cafe = cafe;
		this.cafeName = cafeName;
		this.cookies = cookies;
	}

	public int getCafe() {
		return cafe;
	}

	public void setCafe(int cafe) {
		this.cafe = cafe;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public List<CookieDto> getCookies() {
		return cookies;
	}

	public void setCookies(List<CookieDto> cookies) {
		this.cookies = cookies;
	}
	
	


}
