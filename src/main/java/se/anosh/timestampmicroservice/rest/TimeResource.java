package se.anosh.timestampmicroservice.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import se.anosh.timestampmicroservice.TimeStampService;
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
    public Response getCurrentTime() {
        
        TimeStamp current = service.getCurrent();
        return Response.ok(current).build();
    }
    
    @GET
    @Path("{userInput}")
    @Produces({"application/JSON"})
    public Response getFromUser(@PathParam("userInput") String userInput) {
        
        // kolla parametertyp
        
        return getCurrent();
        
    }
    
    private Response getCurrent() {
        
        TimeStamp result = service.getCurrent();
        return Response.ok(result).build();
    }
    

    private Response getDateFromUser(String date) {
        
         TimeStamp result = service.getTime(date);
         return Response.ok(result).build();
    }
    
    private Response getUnixTimeFromUser(long unixTimeInMilliseconds) {
        
        TimeStamp result = service.getTime(unixTimeInMilliseconds);
        return Response.ok(result).build();
    }
    
    
    
}
    
    
    
