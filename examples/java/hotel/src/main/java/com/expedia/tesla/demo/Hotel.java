package com.expedia.tesla.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

import com.expedia.tesla.schema.annotation.NotNullable;
import com.expedia.tesla.schema.annotation.TypeId;

public class Hotel extends IdObject 
{
	private String name;
    private HashMap<String,String> attributes;
    private Collection<Room> rooms;
    
    public Hotel() {
    }
    
    public Hotel(int id, String name, HashMap<String,String> attributes, Collection<Room> rooms) {
    	super(id);
    	this.name = name;
    	this.attributes = attributes;
    	this.rooms = rooms;
    }
    
    @NotNullable
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	
	@TypeId("array[java.util.Collection,java.util.HashSet]<reference<class<Room>>>)")
	public Collection<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void shop() {
		// do something
	}
}
