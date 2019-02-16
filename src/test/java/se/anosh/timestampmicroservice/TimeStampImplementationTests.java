package se.anosh.timestampmicroservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import se.anosh.timestampmicroservice.domain.TimeStamp;


/**
 * 
 * Tests for the business logic in TimeStampImplementation.java
 * 
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 *
 */
class TimeStampImplementationTests {

	TimeStampImplementation service;
	
	@BeforeEach
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
	
	
	@Test
	public void testInvalidStringInput() {
		
		Executable closureContainingCodeToTest = () -> service.getTime("19930510"); // lambda expression
		assertThrows(GarbageInputException.class,closureContainingCodeToTest, "Expected to throw exception, but it did not");
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
