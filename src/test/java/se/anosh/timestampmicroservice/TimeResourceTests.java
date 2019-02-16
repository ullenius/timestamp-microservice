package se.anosh.timestampmicroservice;

import static org.junit.jupiter.api.Assertions.*;

import javax.ws.rs.core.Response;

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

	@Spy
	TimeResource resource;
	
	@Test
	void testCurrentTimeResponseStatusCode() {
		
		fail();
//		resource = spy(new TimeResource());
//		
//		doReturn(new BigDecimal(10)).when(loanApplication).getInterestRate();
//		
//		
//		Response response = resource.getCurrentTime();
//		assertTrue(response.getStatus() == 200);
		
	}

}
