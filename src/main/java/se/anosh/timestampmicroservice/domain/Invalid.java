package se.anosh.timestampmicroservice.domain;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@XmlRootElement
public final class Invalid {
    
    private final String error;
    
    public Invalid() {
        error = "Invalid string";
    }
    
    
}
