package se.anosh.timestampmicroservice;

import static org.junit.jupiter.api.Assertions.*;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Spy;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import se.anosh.timestampmicroservice.rest.TimeResource;

/**
 * 
 * Tests for the business logic in the REST-layer in
 * TimeResourceTests.java
 * 
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 *
 */

class TimeResourceTests {

	TimeResource testTimeResource;
	
	@BeforeEach
	public void setup() {
		testTimeResource = new TimeResource();
	}
	
	
	
	@Test
	void testCurrentTimeResponseStatusCode() {
		
		fail();
		
		/**
		 * 1. Create a mock TimeStampService
		 * 2. Inject it into testTimeResource
		 * 3. Call the method getCurrenTTime() in testTimeResource
		 * 4. assert status code (int) extracted from return value with expected result
		 * 
		 */
		
		
	}

}
