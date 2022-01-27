
package exceptionapp;

/**
 *
 * @author hncal
 */
public class ArrayOutOfBoundsException extends Exception{
    String message;

    public ArrayOutOfBoundsException(String m) {
        this.message=m;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    
}
