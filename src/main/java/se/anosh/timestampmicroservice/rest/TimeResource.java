package se.anosh.timestampmicroservice.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import se.anosh.timestampmicroservice.TimeStampService;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Path("/timestamp")
public class TimeResource {
    
    @Inject
    TimeStampService service;
    
    
}
    
    
    
