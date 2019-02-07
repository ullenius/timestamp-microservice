package se.anosh.timestampmicroservice.dataaccess;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Local
public interface DataAccess {
    
   public long getUnixdate(Date date);
   public Date getDate(long unixTimeInMilliseconds);
   public Date getCurrentDate();
    
}
