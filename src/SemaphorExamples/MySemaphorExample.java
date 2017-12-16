package SemaphorExamples;

import java.util.concurrent.Semaphore;

public class MySemaphorExample {

    static int sharedVariable = 0;

    public static void main(String args[]) {


        /*
     permits the initial number of permits available.
     This value may be negative, in which case releases
     must occur before any acquires will be granted.*/
        int permit = 1;
        Semaphore sm1 = new Semaphore(permit);
        System.out.println("Semaphore with 1 permit has been created");

        FirstThread first = new FirstThread(sm1);
        new Thread(first).start();

        SecondThread second = new SecondThread(sm1);
        new Thread(second).start();

    }

}

class FirstThread implements Runnable {

    Semaphore semaphore;

    public FirstThread(Semaphore sm) {
        this.semaphore = sm;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " is waiting for permit");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()
                    + " has got permit");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()
                        + " > " + MySemaphorExample.sharedVariable++);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                + " has released permit");
        semaphore.release();
    }

}

class SecondThread implements Runnable {

    Semaphore semaphore;

    public SecondThread(Semaphore sm) {
        this.semaphore = sm;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()
                    + " has got permit");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()
                        + " > " + MySemaphorExample.sharedVariable++);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                + " has released permit");
        semaphore.release();
    }

}
