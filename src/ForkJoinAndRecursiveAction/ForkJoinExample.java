/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoinAndRecursiveAction;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author shubham.goswami
 */
 class  MyRecursiveAction extends RecursiveAction{
 int end;
 int start;
 long[] numbers;

    MyRecursiveAction(int start, int end, long[] numberAr) {
      this.start=start;
      this.end=end;
      this.numbers=numberAr;              
    }
    @Override
    protected void compute() {
                /* We divide array into small arrays, as small as minimumProcessingSize.
            * So that each processor could efficiently process smaller array, using this
            * approach enables work-stealing approach to comes into picture.
            */
           int minimumProcessingSize=2;
           
           //Array is small enough to be processed, we need not to divide array.
           if(end-start < minimumProcessingSize){
                  for (int i = start; i < end; i++) {
                        numbers[i]=numbers[i]*numbers[i];
                  }
           }
           //divide array in small arrays.
           else {
                  int mid= (start+end)/2;
                  
                  invokeAll(new MyRecursiveAction(start, mid,numbers ),
                               new MyRecursiveAction(mid, end, numbers));
           }
    }
    }
      
     public class ForkJoinExample {
    public static void main(String[] args) {
 
           ForkJoinPool forkJoinPool=new ForkJoinPool();
           long startNanoSec=0;
           long endNanoSec=0;
           
           long[] numberAr=new long[10000];
           for(int i=0;i<10000;i++){
                  numberAr[i]=i;
           }
 
           System.out.print("original array : ");
           for(int i=0;i<10;i++){
                  System.out.print(numberAr[i]+" ");
           }
           
           MyRecursiveAction task=new MyRecursiveAction(0,numberAr.length,numberAr);
 
           
           startNanoSec=System.nanoTime();
           forkJoinPool.invoke(task);
           endNanoSec=System.nanoTime();
           
           System.out.print("\narray after being processed recursively "
                        + "using RecursiveAction : ");
           for(int i=0;i<10;i++){
                  System.out.print(numberAr[i]+" ");
           }
           
           System.out.println();
           System.out.println("Level of Parallelism > "+
                                             forkJoinPool.getParallelism());
           System.out.print("Time taken to complete task : "+
                                             (endNanoSec-startNanoSec)+" nanoSeconds");          
    }
}
    

