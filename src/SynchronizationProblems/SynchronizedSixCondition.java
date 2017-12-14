/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SynchronizationProblems;

/**
 *
 * @author shubham.goswami
 */
public class SynchronizedSixCondition implements Runnable{
 
    @Override
    public void run(){
           method1();
    }
    
    synchronized void method1(){
           System.out.println("synchronized void method1() started");
           method2();
           System.out.println("synchronized void method1() ended");
    }
    
 
    static synchronized void method2(){
           System.out.println("in static synchronized method2()");
    }
    
    

 

    public static void main(String args[]) throws InterruptedException{
           
           SynchronizedSixCondition myRunnable1=new SynchronizedSixCondition();
           Thread thread1=new Thread(myRunnable1,"Thread-1");
           thread1.start();        
           
           
    }
 
}