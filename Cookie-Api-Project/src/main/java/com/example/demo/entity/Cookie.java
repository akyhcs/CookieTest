package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cookie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cookieId;
	
	private String cookieName;
	
	private double price;
	
	@ManyToOne
	private Cafe cafe;
	
	

	public Cookie() {
		super();
	}

	public Cookie(int cookieId, String cookieName, double price, Cafe cafe) {
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

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	
	
	

}
