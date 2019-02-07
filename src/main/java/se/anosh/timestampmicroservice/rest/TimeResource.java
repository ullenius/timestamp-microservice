package se.anosh.timestampmicroservice.rest;

import java.text.ParseException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import se.anosh.timestampmicroservice.TimeStampService;
import se.anosh.timestampmicroservice.domain.Invalid;
import se.anosh.timestampmicroservice.domain.TimeStamp;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Path("/timestamp")
public class TimeResource {
    
    @Inject
    TimeStampService service;
    
    @GET
    @Produces({"application/JSON"})
    /**
     * 
     * When no path parameter is given
     */
    public Response getCurrentTime() {
        TimeStamp current = service.getCurrent();
        return Response.ok(current).build();
    }
    
    @GET
    @Path("/{userInput}")
    @Produces({"application/JSON"})
    public Response getFromUser(@PathParam("userInput") String userInput) {
        
        if (userInput == null)
            return getCurrentTime();
        
        try {
            Long unixTime = Long.parseLong(userInput);
            return TimeResource.this.getCustomTime(unixTime);
            
        } catch (NumberFormatException ex) {
            return getCustomTime(userInput);
        }
    }
    
  
    

    private Response getCustomTime(String date) {
        
        try {
         TimeStamp result = service.getTime(date);
         return Response.ok(result).build();
        } catch (ParseException ex) {
            return Response.ok(new Invalid()).build();
        }
    }
    
    private Response getCustomTime(long unixTimeInMilliseconds) {
        
        TimeStamp result = service.getTime(unixTimeInMilliseconds);
        return Response.ok(result).build();
    }
    
    
}
    
    
    
