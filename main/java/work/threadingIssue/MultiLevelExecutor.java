package work.threadingIssue;

import java.util.concurrent.*;
import java.util.logging.Logger;

public class MultiLevelExecutor <T extends MessageObject>{
    private static Logger LOGGER = Logger.getLogger(String.valueOf(MultiLevelExecutor.class));

    private int executorLevel;
    private long lastTouchTime;

    private ExecutorKey executorKey;

    private ExecutorService executorService;

    private CopyOnWriteArrayList<Future<Boolean>> futureCopyOnWriteArrayList;

    private ConcurrentHashMap<ExecutorKey,MultiLevelExecutor> childExecutorKeyToExecutorMap;

    public MultiLevelExecutor(final ExecutorKey executorKey) {
        this(0,executorKey);
    }

    public MultiLevelExecutor(int executorLevel, ExecutorKey executorKey) {
        this.lastTouchTime=System.currentTimeMillis();
        this.executorLevel = executorLevel;
        this.executorKey = executorKey;
        this.executorService = Executors.newSingleThreadExecutor(
                (Runnable runnable)-> new Thread(runnable, executorKey.getKey())
        );
        this.futureCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.childExecutorKeyToExecutorMap = new ConcurrentHashMap<>();
        System.out.println("Executor: {"+ executorKey.getKey()+"} is created");
    }

    public MultiLevelExecutor() {
    }

    /**
     * submit a task with executor key
     */

    public CompletableFuture<Boolean> submit( final ExecutorKey executorKey, final SimpleMultiLevelTask task){
        if (!executorKey.getKey().equals(task.getKeyForLevel(executorLevel))){
            throw new AssertionError();
        }
        if(executorLevel==0){
            //QueuedMessageCounter.incrementAndGet();
        }
        final ExecutorLevelTask<T> executorLevelTask = new ExecutorLevelTask<T>(task, this);
        return null;
    }

    public int getExecutorLevel() {
        return executorLevel;
    }

    /**
     * Waits for child futures to complete
     * This method should be called from ExecutorLevelTask only.
     */
    public void waitForChildTasks() {
        for (MultiLevelExecutor childExecutor :
                childExecutorKeyToExecutorMap.values()) {
            childExecutor.waitForChildTasks(); // recursive call
            CopyOnWriteArrayList<Future<Boolean>> childFutureList = childExecutor.futureCopyOnWriteArrayList;
            //LOGGER.info();

        }

    }
}
