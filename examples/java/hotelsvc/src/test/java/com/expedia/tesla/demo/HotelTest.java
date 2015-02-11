package com.expedia.tesla.demo;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.expedia.tesla.serialization.TeslaSerializationException;

public class HotelTest {
	
	@Test
	public void test() throws TeslaSerializationException, IOException {
		List<Room> rooms = new LinkedList<Room>();
		rooms.add(new Room(1, "Standard Room", 100));
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put("start", "***");
		attributes.put("type", "motel");
		Hotel hotel = new Hotel(123, "ABC Hotel", attributes, rooms);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		Serializer.newJsonWriter(Serializer.VERSION_DEMO_V1, os).write(hotel);
		
		Hotel newHotel = new Hotel();
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		Serializer.newJsonReader(Serializer.VERSION_DEMO_V1, is).read(newHotel);
		
		assertEquals(hotel.getId(), newHotel.getId());
		assertEquals(hotel.getName(), newHotel.getName());
		assertEquals(hotel.getAttributes(), newHotel.getAttributes());
		
	}

}
