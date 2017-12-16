/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VolatileKeyword;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shubham.goswami
 */
public class ControlFourThreadsInJava {
    
    
    public boolean one=true;
    public boolean two=false;
    public boolean three=false;
    public boolean four=false;
    
    public synchronized void one() throws InterruptedException{
        if(one){
        System.out.println("Name " + Thread.currentThread().getName()+"----->"+"ONE");
        one=false;
        two=true;
        three=false;
        four=false;
        }
        wait();
        
    }
    public synchronized void two(){
         if(two){
        System.out.println("Name " + Thread.currentThread().getName()+"----->"+"TWO");
        one=false;
        two=false;
        three=true;
        four=false;
        }
       notifyAll();
    }
    public synchronized void three(){
       if(three){
        System.out.println("Name " + Thread.currentThread().getName()+"----->"+"THREE");
        one=false;
        two=false;
        three=false;
        four=true;
        }
       notifyAll(); 
    }
    public synchronized void Four(){
        if(four){
        System.out.println("Name " + Thread.currentThread().getName()+"----->"+"FOUR");
        one=true;
        two=false;
        three=false;
        four=false;
        }
       notifyAll();
        
    }
    
    
    
public static void main(String args[]){
         ControlFourThreadsInJava o1=new ControlFourThreadsInJava();
new Thread(){
   public void run(){
       try {
           while(true)
           o1.one();
       } catch (InterruptedException ex) {
           Logger.getLogger(ControlFourThreadsInJava.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}.start();
new Thread(){
     public void run(){
         while(true){
       o1.two();
         }
   }
    
}.start();
new Thread(){
     public void run(){
         while(true){
       o1.three();
         }
   }
    
}.start();
new Thread(){
     public void run(){
         while(true){
         o1.Four();
         }
       
   }
    
}.start();
        
}
    
}
