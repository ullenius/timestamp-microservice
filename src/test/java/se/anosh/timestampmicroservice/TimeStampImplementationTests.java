package se.anosh.timestampmicroservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import se.anosh.timestampmicroservice.domain.TimeStamp;

class TimeStampImplementationTests {

	TimeStampImplementation service;
	
	@Before
	public void setup() {
		System.out.println("running setup");
		
	}
	
	
	@Test
	public void testCurrentUnixTime() {
		
		assertTrue( (new Date().getTime() == service.getCurrent().getUnix()));
		
	}
	
	@Test
	public void testCurrentUTC() {
		
		TimeStamp stamp = 
		fail();
	}

}
