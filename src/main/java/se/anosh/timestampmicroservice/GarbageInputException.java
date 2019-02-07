/**
 * 
 * Custom exception since EJB's perform rollback in case of
 * runtime-exceptions causing everything to crash and burn :(
 * 
 * 
 * Is manually thrown when user submits invalid input (failed date parsing)
 * or illegal unix-time
 * 
 */
package se.anosh.timestampmicroservice;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public class GarbageInputException extends Exception {
    
    public GarbageInputException() {
    }
    
    public GarbageInputException(String message) {
        super(message);
    }
    
}
