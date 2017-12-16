
package LockInterFaceExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



class MyThread implements Runnable{
    ReentrantLock lock;
    public MyThread(ReentrantLock lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Waiting to accquir a lock");
        lock.lock();
        System.out.println(Thread.currentThread().getName()
                + " accquired a lock");
        try{
            Thread.sleep(2000);
            
        }catch(InterruptedException e){
            
        }
        System.out.println(">>>>--- getQueueLength = "+lock.getQueueLength()+"---<<<<");
           
        lock.unlock();
        System.out.println(Thread.currentThread().getName()
                + " released a lock");
        
    }
}




public class ReentrantLockGetQueuedThreadTest {
    public static void main(String args[]){
        ReentrantLock l =new ReentrantLock();
        Thread obj1=new Thread(new MyThread(l));
        Thread obj2=new Thread(new MyThread(l));
        Thread obj3=new Thread(new MyThread(l));
        obj1.start();
        obj2.start();
        obj3.start();
        
    }
    
}
