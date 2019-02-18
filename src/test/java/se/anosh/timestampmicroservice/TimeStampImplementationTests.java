package se.anosh.timestampmicroservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import se.anosh.timestampmicroservice.domain.TimeStamp;


/**
 * 
 * Tests for the business logic in TimeStampImplementation.java
 * 
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 *
 */
public class TimeStampImplementationTests {
	
	public TimeStampImplementationTests() {
		// default zero-argument constructor
	}

	TimeStampImplementation service;
	
	@Before
	public void setup() {
		service = new TimeStampImplementation();
	}
	
	
	@Test
	public void testValidCurrentUnixTime() {
		assertTrue( (new Date().getTime() == service.getCurrent().getUnix()));
	}
	
	@Test
	public void testInvalidCurrentUnixTime() throws InterruptedException {
		
		Date d = new Date();
		Thread.sleep(10);
		assertFalse(d.getTime() == service.getCurrent().getUnix());
	}
	
	
	@Test(expected = GarbageInputException.class)
	public void testInvalidStringInput() throws GarbageInputException {
		
		service.getTime("19930510"); // lambda expression
	}
	
	@Test
	public void testValidConversionFromDateString() {
		
		final long expectedResult = 1451001600000L;
		try {
			TimeStamp stamp = service.getTime("2015-12-25");
			assertTrue(stamp.getUnix() == expectedResult);
			
		} catch (GarbageInputException e) {
			fail(); // this should never happen anyway...
		}
		
	}
	
	@Test
	public void testInvalidConversionFromDateString() {
		
		final long falseResult = 1451001600001L; // changed last digit to 1
		try {
			TimeStamp stamp = service.getTime("2015-12-25");
			assertFalse(stamp.getUnix() == falseResult);
			
		} catch (GarbageInputException e) {
			fail(); // this should never happen anyway...
		}
		
	}

	
	

}
