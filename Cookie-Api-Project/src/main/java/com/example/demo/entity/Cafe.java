package com.example.demo.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cafe {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cafe;

	private String cafeName;
	
	@OneToMany(mappedBy = "cafe")
	List<Cookie> cookies;


	public Cafe() {
		super();
	}

	public Cafe(int cafe, String cafeName, List<Cookie> cookies) {
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

	public List<Cookie> getCookies() {
		return cookies;
	}

	public void setCookies(List<Cookie> cookies) {
		this.cookies = cookies;
	}
		

}
