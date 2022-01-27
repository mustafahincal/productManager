
package exceptionapp;

/**
 *
 * @author hncal
 */
public class BadNumberException extends Exception {
    
    String message;

    public BadNumberException(String m) {
      this.message=m;
    }
    
    public String getMessage(){
        return message;
    }
    
}
