package se.anosh.timestampmicroservice.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@XmlRootElement
public class TimeStamp {
    
    private long unix;
    private String utc;

    public TimeStamp() {
        // zero argument constructor
    }
    
    public TimeStamp(long unix, String utc) {
        this.unix = unix;
        this.utc = utc;
    }
    
    public long getUnix() {
        return unix;
    }

    public void setUnix(long unix) {
        this.unix = unix;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }
    
}
