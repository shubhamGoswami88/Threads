
package ThreadExceptions;

import java.util.logging.Level;
import java.util.logging.Logger;


public class IllegalStateOfExceptionUsingWait extends Thread {

    Object ob=new Object();
    public void run(){
        
        try {
            ob.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(IllegalStateOfExceptionUsingWait.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
      IllegalStateOfExceptionUsingWait illw=new IllegalStateOfExceptionUsingWait();
      illw.start();
    }
    
}
