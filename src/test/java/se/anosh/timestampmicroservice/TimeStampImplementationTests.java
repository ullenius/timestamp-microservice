package se.anosh.timestampmicroservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import se.anosh.timestampmicroservice.domain.TimeStamp;

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

	
	

}
