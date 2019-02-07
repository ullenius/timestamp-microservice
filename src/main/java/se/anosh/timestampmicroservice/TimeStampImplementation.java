package se.anosh.timestampmicroservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import se.anosh.timestampmicroservice.domain.TimeStamp;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Default
@Stateless
public class TimeStampImplementation implements TimeStampService {

   
    @Override
    public TimeStamp getCurrent() {
        return factory();
    }

    @Override
    public TimeStamp getTime(long unixTime) {
        
        String utc = unixTimeToUTC(unixTime);
        return new TimeStamp(unixTime,utc);
    }

    @Override
    public TimeStamp getTime(String target) throws ParseException {
        
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        Date result = df.parse(target);
        long unix = result.getTime();
        String utc = unixTimeToUTC(unix);
        
        return new TimeStamp(unix,utc);
    }
     /**
     * Returns UTC time formatted with US locale
     * 
     * Example: "Sun, 20 Nov 2016 17:31:29 GMT"
     * 
     */
    private String unixTimeToUTC(long unixTimeInMilliseconds) {
        
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Date date = new Date(unixTimeInMilliseconds);
        String dateString = formatter.format(date);
        return dateString;
    }
    
    /**
     * Creates a Timestamp object using the current time
     * @return
     */
    private TimeStamp factory() {
        
        Date now = new Date();
        long unix = now.getTime();
        String utc = unixTimeToUTC(unix);
        return new TimeStamp(unix,utc);
    }

    
    
}
