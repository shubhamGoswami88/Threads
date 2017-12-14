/*
 * Suppose you have 2 threads (Thread-1 on object1 and Thread-2 on object2). 
Thread-1 is in static synchronized method1(), 
can Thread-2 enter static synchronized method2() at same time?
 */
package SynchronizationProblems;

/**
 *
 * @author shubham.goswami
 */
public class SynchronizedSeventhCondition implements Runnable{
 
    @Override
    public void run(){
           if(Thread.currentThread().getName().equals("Thread-1"))
                  method1();
           else
                  method2();
    }
 
    static synchronized void method1(){
           System.out.println(Thread.currentThread().getName()+
                        " in synchronized void method1() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()
                        +" in synchronized void method1() ended");
    }
    
    static synchronized void method2(){
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
 
           
}
    

