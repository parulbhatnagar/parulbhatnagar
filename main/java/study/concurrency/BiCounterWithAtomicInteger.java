package study.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithAtomicInteger {

    // Lock helps us to break synchornize in multiple blocks
    private AtomicInteger i = new AtomicInteger();
    private AtomicInteger j = new AtomicInteger();
    synchronized public void incrementI(){
        //Get Lock for I
        i.incrementAndGet();

        //Release Lock for J
    }
    synchronized public void incrementJ(){
        //Get Lock for J
        j.incrementAndGet();
        //Release Lock for J
    }


    // Only one thread can be running on all the synchronized code on an instance - significant performance impact


    public int getI() {
        return i.get();
    }

    public void setI(int i) {
        this.i.set(i);
    }
}
