package study.thredaing;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //Future<String> welcomeFuture =  executorService.submit(new CallableTask("Testing Thread Work"));

        List<CallableTask> callableTaskList = List.of(
                new CallableTask("Testing Thread Work1") ,
                new CallableTask("Testing Thread Work2") ,
                new CallableTask("Testing Thread Work3") ,
                new CallableTask("Testing Thread Work4")
        );

        String result = executorService.invokeAny(callableTaskList);
        System.out.println(result);

/*        for (Future<String> result :
                results) {
            System.out.println(result.get());
        }*/
        executorService.shutdown();
        System.out.println("");
        System.out.println("main is completed");
    }
}
