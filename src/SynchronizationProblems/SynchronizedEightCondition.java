/*
 * Suppose you have 2 threads (Thread-1 on object1 and Thread-2 on object2). 
   Thread-1 is in synchronized method1(), can Thread-2 enter synchronized method2() at same time?
 */
package SynchronizationProblems;

/**
 *
 * @author shubham.goswami
 */
public class SynchronizedEightCondition implements Runnable{
 
    @Override
    public void run(){
           if(Thread.currentThread().getName().equals("Thread-1"))
                  method1();
           else
                  method2();
    }
 
    synchronized void method1(){
           System.out.println(Thread.currentThread().getName()+
                        " in synchronized void method1() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+
                        " in synchronized void method1() ended");
    }
    
    synchronized void method2(){
           System.out.println(Thread.currentThread().getName()
                        +" in synchronized void method2() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()
                        +" in synchronized void method2() ended");
    }
 
           

 
    public static void main(String args[]) throws InterruptedException{

 
           SynchronizedEightCondition object1=new SynchronizedEightCondition();
           SynchronizedEightCondition object2=new SynchronizedEightCondition();
           
           Thread thread1=new Thread(object1,"Thread-1");
           Thread thread2=new Thread(object2,"Thread-2");
           thread1.start();        
           Thread.sleep(10);//Just to ensure Thread-1 starts before Thread-2
           thread2.start();        
           
           
    }
 
}
