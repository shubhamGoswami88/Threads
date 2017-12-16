
package ForkJoinAndRecursiveAction;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class RecursiveActionSetup extends RecursiveTask<Long>{
    
    int start;
    int end;
    long[]numbers;
    
    RecursiveActionSetup(int start,int end,long[] numbers){
        this.start=start;
        this.end=end;
        this.numbers=numbers;
    }
    
    
    
  

    protected Long compute(){
       int RecursiveActionSetup=100;
       long sum=0;
       if(end-start<RecursiveActionSetup){
        for(int i=start;i<end;i++){
            
                sum+=numbers[i];
            }
       }else{
                int mid=(start+end)/2;
                MyRecursiveAction task1=new MyRecursiveAction(start, mid, numbers);
                MyRecursiveAction task2=new MyRecursiveAction(mid, end, numbers);
                
                
                //We will submit subTasks by using fork() method,
                  //fork() method submits the tasks asynchronously, i.e. it
                  //won't wait for tasks to finish.
                  task1.fork();
                  task2.fork();
                  
                  //join() method waits for subtask to return result.
                  //Once task will complete it will return and result will be
                  //available. Then we will sum up the result returned by two tasks. 
                 task1.join();
                 task2.join();
                
            }
        
    
        
      return sum ;  
        
    }
    
}
public class ForljoinExampleSumOfTheNumbers {
    
   public static void main(String args[]){
     ForkJoinPool forkJoinPool=new ForkJoinPool();
           
           long[] numberAr=new long[100000];
           for(int i=0;i<100000;i++){
                  numberAr[i]=i;
           }
    
           RecursiveActionSetup task=new RecursiveActionSetup(0,numberAr.length,numberAr);
 
           //store returned result in sum variable.
           long sum = forkJoinPool.invoke(task);
           System.out.println("sum of 100000 elements returned by compute() method = "+sum);  
   }
    
}
