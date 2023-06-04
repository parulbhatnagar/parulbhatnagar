package study.concurrency;

public class Counter {
    int i;

    synchronized public void increment(){
        i++;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
