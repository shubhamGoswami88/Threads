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
public class SynchronizationSecondConditionWithStaticMethod implements Runnable{

 @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-1")) {
            method1();
        } else {
            method2();
        }
    }

    synchronized static void method1() {

        System.out.println(Thread.currentThread().getName() + " " + " Start in method1");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + " " + " End in method1");
    }

    synchronized static void method2() {
        System.out.println(Thread.currentThread().getName() + " " + " Start in method2");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + " " + " End in method2");
    }
    public static void main(String args[]){
        SynchronizationSecondConditionWithStaticMethod secondCond=new SynchronizationSecondConditionWithStaticMethod();
        Thread thread1=new Thread(secondCond,"Thread-1");
        Thread thread2=new Thread(secondCond,"Thread-2");
        thread1.start();
        thread2.start();
        
        
    }
}
