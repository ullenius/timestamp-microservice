package se.anosh.timestampmicroservice;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    /**
     * This method is a mess. But it works
     * 
     * Parses the date to localdate, sets the timezone to utc
     * and the time to 00:00. Then converts it to Unix time in ms
     * using the Date-class' from-method
     */
    public TimeStamp getTime(String target) throws GarbageInputException {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
        final LocalDate other = LocalDate.parse(target,formatter);
        long unix = Date.from(other.atStartOfDay(ZoneId.of("UTC")).toInstant()).getTime();
        String utc = unixTimeToUTC(unix);
        return new TimeStamp(unix,utc);
        } catch (DateTimeParseException ex) {
            throw new GarbageInputException("date parsing failed");
        }
        
    }
     /**
     * Returns UTC time formatted with US locale
     * 
     * Example: "Sun, 20 Nov 2016 17:31:29 GMT"
     * 
     */
    private String unixTimeToUTC(long unixTimeInMilliseconds) {
        
        String pattern = "E dd MMM yyyy HH:mm:ss z";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Date date = new Date(unixTimeInMilliseconds);
        String dateString = sdf.format(date);

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
