package study.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithLock {

    // Lock helps us to break synchornize in multiple blocks
    private int i;
    private int j;

    Lock lockForI = new ReentrantLock();
    Lock lockForJ = new ReentrantLock();

    synchronized public void incrementI(){
        //Get Lock for I
        lockForI.lock(); // if no other thread has lock then it will take a lock
        i++;
        lockForI.unlock();

        //Release Lock for J
    }
    synchronized public void incrementJ(){
        //Get Lock for J
        lockForJ.tryLock();
        j++;
        //Release Lock for J
        lockForJ.unlock();
    }


    // Only one thread can be running on all the synchronized code on an instance - significant performance impact


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
