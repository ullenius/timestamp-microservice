package se.anosh.timestampmicroservice.rest;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import se.anosh.timestampmicroservice.GarbageInputException;
import se.anosh.timestampmicroservice.TimeStampService;
import se.anosh.timestampmicroservice.domain.TimeStamp;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Path("/timestamp")
public class TimeResource {
    
    private static final int BAD_REQUEST = 400; //http status-code
    
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
    
    /**
     * 
     * This method first checks whether or not it has received a Long (unix-time) or
     * a String. First it tries to parse it as a long. If that fails the input parameter
     * is presumed to be a date in String-format.
     * 
     * @param userInput
     * @return
     */
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
        } catch (GarbageInputException ex) {
            return Response.status(BAD_REQUEST).entity(new ErrorMessage("Invalid Date")).build();
        }
    }
    
    private Response getCustomTime(long unixTimeInMilliseconds) {
        
        TimeStamp result = service.getTime(unixTimeInMilliseconds);
        return Response.ok(result).build();
    }
    
    /**
     * This class' sole purpose is to contain
     * an error String. Then the whole object
     * is converted into XML or JSON by JAX-RS.
     * 
     * Rather than having to hard-code JSON
     * or XML.
     * 
     * This class is immutable (dependency injection)
     */
    @XmlRootElement
    private class ErrorMessage {
        
        @XmlElement(name = "error")
        final private String message;
        public ErrorMessage(String message) {
            this.message = Objects.requireNonNull(message);
        }
        @Override
        public String toString() {
            return "message: " + message;
        }
    }
    
    
    
}
    
    
    
