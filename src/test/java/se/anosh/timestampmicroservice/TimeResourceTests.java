package se.anosh.timestampmicroservice;

import static org.junit.jupiter.api.Assertions.*;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import se.anosh.timestampmicroservice.rest.TimeResource;

import static org.mockito.Mockito.*;

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

	
	@Test
	void testCurrentTimeResponseStatusCode() {
		
		TimeResource resource = Mockito.spy(new TimeResource());
		Response response = resource.getCurrentTime();
		assertTrue(response.getStatus() == 200);
		
	}

}
