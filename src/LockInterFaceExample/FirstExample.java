
package LockInterFaceExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



class MyThread1 implements Runnable{
    Lock lock;
    public MyThread1(Lock lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Waiting to accquir a lock");
        lock.lock();
        System.out.println(Thread.currentThread().getName()
                + " accquired a lock");
        try{
            Thread.sleep(5000);
            
        }catch(InterruptedException e){
            
        }
        ;
        lock.unlock();
        System.out.println(Thread.currentThread().getName()
                + " released a lock");
        
    }
}




public class FirstExample {
    public static void main(String args[]){
        Lock l =new ReentrantLock();
        Thread obj1=new Thread(new MyThread1(l));
        Thread obj2=new Thread(new MyThread1(l));
        obj1.start();
        obj2.start();
        
    }
    
}
