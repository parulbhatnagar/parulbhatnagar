package study.thredaing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

class TaskForRunning extends  Thread {
    private int taskNumber;

    public TaskForRunning(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void run(){
        //Task3
        System.out.println("\nTask"+ taskNumber + " started ");
        for (int i = 100*taskNumber; i < (100*taskNumber + 99); i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask"+ taskNumber + " done");
    }
}

class TaskReturningAnIntegers implements Callable{

    private int number;

    public TaskReturningAnIntegers(int number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Start for TaskReturningAnIntegers for " + number);

        WhyNotFuture.delay(10);

        System.out.println("inseide call() for TaskReturningAnIntegers for " + number);
        return number*number;
    }
}
public class WhyNotFuture {

    public static void main(String[] args) {
        try {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // specified number of threads will be pooled by the tasks

/*        executorService.execute(new TaskForRunning(1));
        executorService.execute(new TaskForRunning(2));
        executorService.execute(new TaskForRunning(3));
        executorService.execute( new TaskForRunning(4));
        executorService.execute(new TaskForRunning(5));*/

            List<Integer> integerList = new ArrayList<>();

            Future<Integer> futureOfInteger1 = executorService.submit(new TaskReturningAnIntegers(1));
            integerList.add(futureOfInteger1.get());
            Future<Integer> futureOfInteger2 = executorService.submit(new TaskReturningAnIntegers(2));
            integerList.add(futureOfInteger2.get());

            Future<Integer> futureOfInteger3 = executorService.submit(new TaskReturningAnIntegers(3));
            integerList.add(futureOfInteger3.get());

            Future<Integer> futureOfInteger4 = executorService.submit(new TaskReturningAnIntegers(4));
            integerList.add(futureOfInteger4.get());

            Future<Integer> futureOfInteger5 = executorService.submit(new TaskReturningAnIntegers(5));

            integerList.add(futureOfInteger5.get());

            System.out.println(integerList);
            executorService.shutdown();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }





    }

    public static void delay(int min){
        try{
            TimeUnit.SECONDS.sleep(min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
