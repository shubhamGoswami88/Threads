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
public class SynchronizedNonStaticMethodsFirstCondition implements Runnable {

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-1")) {
            method1();
        } else {

            method2();

        }

    }

    synchronized void method1() {

        System.out.println(Thread.currentThread().getName() + " " + " Start in method1");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + " " + " End in method1");
    }

    synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " " + " Start in method2");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + " " + " End in method2");
    }

    public static void main(String args[]) throws InterruptedException {

        SynchronizedNonStaticMethodsFirstCondition thread = new SynchronizedNonStaticMethodsFirstCondition();
        Thread o1 = new Thread(thread, "Thread-1");
        Thread o2 = new Thread(thread, "Thread-2");
        o1.start();
        o1.sleep(10);
        o2.start();

    }
}
