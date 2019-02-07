package se.anosh.timestampmicroservice;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import se.anosh.timestampmicroservice.dataaccess.DataAccess;
import se.anosh.timestampmicroservice.domain.TimeStamp;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public class TimeStampImplementation implements TimeStampService {

    /**
     * Returns UTC time formatted with US locale
     * OMFG
     * 
     */
    
    @Inject
    private DataAccess da;
    
    public String unixTimeToString(long unixTimeInMilliseconds) {
        
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Date date = new Date(unixTimeInMilliseconds);
        String dateString = formatter.format(date);
        return dateString;
    }

    @Override
    public String parseDate(Date date) {

        return unixTimeToString(date.getTime());
    }

    @Override
    public long getUnixTime(Date date) {
        
        return date.getTime();
    }
    
    
    
    /**
     * Creates a Timestamp object using the current time
     * @return 
     */
    private TimeStamp factory() { 
        
        TimeStamp current = new TimeStamp();
        Date now = new Date();
        
        current.setUnix(now.getTime());
        current.setUtc(service.parseDate(now));

        return current;
    }

    
    
}
