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
	public void testInvalidUnixTimeInput() {
		
		
		fail();
//		Executable closureContainingCodeToTest = () ->
//			service.getTime(-15);
//		
//			assertThrows(GarbageInputException.class,closureContainingCodeToTest, "Expected to throw exception, but it did not");
		
	}
	
//	@Test
//	void exceptionTesting() {
//	    Executable closureContainingCodeToTest =
//	      // This represents production code that is expected to throw
//	      () -> throw new IllegalArgumentException("a message");
//
//	    assertThrows(IllegalArgumentException.class,
//	      closureContainingCodeToTest,
//	      "We expect the code under test to throw, but it didn't");
//	}
	
	

}
