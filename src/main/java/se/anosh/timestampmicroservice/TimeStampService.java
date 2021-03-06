package se.anosh.timestampmicroservice;

import se.anosh.timestampmicroservice.domain.TimeStamp;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public interface TimeStampService {
    
    public TimeStamp getCurrent();
    public TimeStamp getTime(long unixTime);
    public TimeStamp getTime(String date) throws GarbageInputException;
    
}
