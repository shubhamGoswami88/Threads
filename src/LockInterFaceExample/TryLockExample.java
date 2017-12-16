
package LockInterFaceExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


 class TryLockThreadImp implements Runnable{
    Lock lock;
    public TryLockThreadImp(Lock lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Waiting to accquir a lock");
        if(lock.tryLock()){
        System.out.println(Thread.currentThread().getName()
                + " accquired a lock");
        try{
            Thread.sleep(5000);
            
        }catch(InterruptedException e){
            
        }        
    }else{
          System.out.println(Thread.currentThread().getName()
                + " did'nt get a lock");  
        }
}
 }

public class TryLockExample {
    public static void main(String args[]){
        Lock l =new ReentrantLock();
        Thread obj1=new Thread(new TryLockThreadImp(l));
        Thread obj2=new Thread(new TryLockThreadImp(l));
        obj1.start();
        obj2.start();
        
    }   
}
    

