package work.threadingIssue;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class ExecutorLevelTask<T extends MessageObject> implements Callable<Boolean> {
    private static Logger LOGGER = Logger.getLogger(String.valueOf(ExecutorLevelTask.class));

    private final SimpleMultiLevelTask<T> task;
    private final MultiLevelExecutor executor;

    public ExecutorLevelTask(SimpleMultiLevelTask<T> task, MultiLevelExecutor executor) {
        this.task = task;
        this.executor = executor;
    }

    @Override
    public Boolean call() throws Exception {
        LOGGER.info("Received Task:" + task.toString());
        if (task.getTaskLevel() == executor.getExecutorLevel()){
            try{
                executor.waitForChildTasks();
                LOGGER.info("Executing Task: "+ task.toString());
                //return task.call();
            }
            catch (Exception e){

            }

        }
        return null;
    }
}
