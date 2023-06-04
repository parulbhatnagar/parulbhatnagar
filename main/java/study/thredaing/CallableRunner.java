package study.thredaing;

import java.util.concurrent.*;

class CallableTask implements Callable<String>{ /// Thread with some returnable value

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}

public class CallableRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> welcomeFuture =  executorService.submit(new CallableTask("Testing Thread Work"));

        System.out.println("");
        System.out.println("new CallableTask(\"Testing Thread Work\") executed");
        String welcomeMessage = welcomeFuture.get();

        System.out.println(welcomeMessage);
        executorService.shutdown();
        System.out.println("");
        System.out.println("main is completed");

    }
}
