/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VolatileKeyword;

/**
 *
 * @author shubham.goswami
 */
public class Example1  {
    
    static int x = 0, y = 0;
    
    static void method1() {
           x++; y++;
    }
    static void method2() {
           System.out.println("x=" + x + " y=" + y);
    }
    
    public static void main(String[] args) {
           Thread thread1=new Thread(){
                  public void run(){
                        for(int i=0; i<10;i++)
                               method1();
                        
                  }
           };
 
           Thread thread2=new Thread(){
                  public void run(){
                        for(int i=0; i<10;i++)
                               method2();
                        
                  }
           };
           
           thread1.start();
           thread2.start();
    }
}
    

