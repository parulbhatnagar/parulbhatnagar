package study.thredaing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task extends Thread{
    private int number;
    public Task(int number){
        this.number=number;
    }
    public void run(){
        //Task3
        System.out.println("\nTask"+ number + " started ");
        for (int i = 100*number; i < (100*number + 99); i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask"+ number + " done");
    }
}
public class ExecutorServiceRunner {
    public static void main(String[] args) {
        System.out.println("\nMain is started");

        //ExecutorService executorService = Executors.newSingleThreadExecutor(); // Task1 and Task2 in single thread
        ExecutorService executorService = Executors.newFixedThreadPool(2); // specified number of threads will be pooled by the tasks
        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        executorService.execute(new Task(4));
        executorService.execute(new Task(5));

        executorService.shutdown();
    }
}
