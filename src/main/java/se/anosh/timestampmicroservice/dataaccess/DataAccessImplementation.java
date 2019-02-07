package se.anosh.timestampmicroservice.dataaccess;

import java.util.Date;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Default
public class DataAccessImplementation implements DataAccess
{

    @Override
    public long getUnixdate(Date date) {
        Objects.requireNonNull(date, "Null values are not acceptable");
        return date.getTime();
    }

    @Override
    public Date getDate(long unixDateInMilliseconds) {
        return new Date(unixDateInMilliseconds);
    }

    @Override
    public Date getCurrentDate() {
        return new Date();
    }
    
}
