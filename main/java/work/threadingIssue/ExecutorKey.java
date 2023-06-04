package work.threadingIssue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorKey extends ReentrantLock {

    private final String key;
    private static final ConcurrentHashMap<String,ExecutorKey> keyMap = new ConcurrentHashMap<>();


    public ExecutorKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static void removeExecutorKey(final ExecutorKey executorKey){
        if(keyMap.contains(executorKey)){
            keyMap.remove(executorKey);
        }
    }
}
