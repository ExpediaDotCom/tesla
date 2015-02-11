package com.expedia.tesla.demo;

public class Room extends IdObject {
	public Room(int id, String name, double price) {
		super(id);
		this.name = name;
		this.price = price;
	}
	
	public Room() {
	}
	
	private String name;
    private Double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
