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
public class SynchronizedFourthConditionWithStaticAndNonStaticMethod implements Runnable{

    synchronized static void methodNonStatic() {
        System.out.println("Synchronized Static method");
        
    }

    @Override
    public void run() {
        method();
    }

   synchronized   void method() {
       System.out.println("Synchronized Non-static method Start");
       methodNonStatic();
       System.out.println("Synchronized Non-Static method End");
    }
   
   public static void main(String args[]){
       SynchronizedFourthConditionWithStaticAndNonStaticMethod m1=new SynchronizedFourthConditionWithStaticAndNonStaticMethod();
       Thread o1=new Thread(m1);
       o1.start();
   }
    
}
