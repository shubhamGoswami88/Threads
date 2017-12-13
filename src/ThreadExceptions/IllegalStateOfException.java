package ThreadExceptions;

public class IllegalStateOfException extends Thread {

    Object lock = new Object();

    public void run() {
        try {
            lock.notify();
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
        }
    }


public static void main(String args[]){
    IllegalStateOfException o2=new IllegalStateOfException();
    o2.start();
    
}

}