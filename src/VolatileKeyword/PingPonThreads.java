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
public class PingPonThreads {
    
private volatile boolean pingpong =true;


public  synchronized void ping() throws InterruptedException{
    if(pingpong){
    System.out.println("Ping");
    pingpong=false;
    }
    wait();
}    
public  synchronized void pong(){
     if(!pingpong){
    System.out.println("Pong");
    pingpong=true;
    }
    notifyAll();
}    
    
  public static void main(String args[]){
      final PingPonThreads p1= new PingPonThreads();
      new Thread(){
          public void run(){
              while(p1.pingpong){
              try {
                  p1.ping();
              } catch (InterruptedException ex) {
                  Logger.getLogger(PingPonThreads.class.getName()).log(Level.SEVERE, null, ex);
              }
              
          }
          }
      }.start();
      new Thread(){
           public void run(){
               while(!p1.pingpong){
               p1.pong();
               }
          }
          
      }.start();
  } 
    
    
    

//    private final int MAX = 10;
//    private  int counter = 0;
//    private  boolean ponged = true;
// 
//    public synchronized void ping() {
//        try {
//            if (ponged) {
//                counter++;
//                System.out.println("Ping");
//                ponged = false;
//            }
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
// 
//    public synchronized void pong() {
//        if (!ponged) {
//            counter++;
//            System.out.println("Pong");
//            ponged = true;
//        }
//        notifyAll();
//    }
// 
//    public static void main(String... arg) {
//        final PingPonThreads pingpong = new PingPonThreads();
//        new Thread() {
//            public void run() {
//                while (true)
//                    pingpong.ping();
//            }
//        }.start();
//        new Thread() {
//            public void run() {
//                while (true)
//                    pingpong.pong();
//            }
//        }.start();
//    }
}

