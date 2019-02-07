
import java.util.Date;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public interface TimeStampService {
    
    public String getTime();
    public String parseDate(long unixTime); // 32bit signed
    public long getUnixTime(Date date);
    
}
