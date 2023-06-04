package work.threadingIssue;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class SimpleMultiLevelTask<T extends MessageObject> extends MultiLevelExecutor{

    private static Logger LOGGER = Logger.getLogger(String.valueOf(SimpleMultiLevelTask.class));

    public static final String GLOBAL="GLOBAL";

    public final String portfolioId;
    public final String custodian;

    private final T message;
    private final String TaskId;
    private final Semaphore semaphore;

    public SimpleMultiLevelTask(final String portfolioId,
                                final String custodian,
                                final T message,
                                final String taskId,
                                Semaphore semaphore) {
        this.portfolioId = portfolioId;
        this.custodian = custodian;
        this.message = message;
        TaskId = taskId;
        this.semaphore = semaphore;
    }

    public String getKeyForLevel(int executorLevel) {
        switch (executorLevel){
            case 0:
                return portfolioId;
            case 1:
                return  portfolioId+"-"+custodian;
            default:
                throw new RuntimeException("Invalid task level");
        }
    }

    @Override
    public String toString() {
        return "SimpleMultiLevelTask{" +
                "portfolioId='" + portfolioId + '\'' +
                ", custodian='" + custodian + '\'' +
                ", message=" + message +
                ", TaskId='" + TaskId + '\'' +
                ", semaphore=" + semaphore +
                '}';
    }

    public int getTaskLevel() {
        return custodian.isBlank() || custodian.equalsIgnoreCase(GLOBAL)? 0: 1;
    }
}
