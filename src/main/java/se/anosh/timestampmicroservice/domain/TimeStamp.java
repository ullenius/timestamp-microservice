package se.anosh.timestampmicroservice.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@XmlRootElement
public class TimeStamp implements Comparable<TimeStamp> {
    
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

    public String getUtc() {
        return utc;
    }

	@Override
	public String toString() {
		return "TimeStamp [unix=" + unix + ", utc=" + utc + "]";
	}

    @Override
    public int compareTo(TimeStamp t) {
        return Long.compare(unix, t.getUnix());
    }
    
    
}
