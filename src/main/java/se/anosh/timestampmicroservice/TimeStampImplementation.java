
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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
    public String getTime(long unixTime) {
        
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Date date;
        if (unixTime == -1) // no date given, use current time
            date= new Date();
        else {
            date = new Date(unixTime);
        }
        
        String dateString = formatter.format(date);
        return dateString;
    }

    @Override
    public String parseDate(long unixTime) {

        return getTime(unixTime);
    }

    @Override
    public long getUnixTime(Date date) {
        
        return date.getTime();
    }

    @Override
    public String getTime() {
        return getTime(-1);
    }
    
}
