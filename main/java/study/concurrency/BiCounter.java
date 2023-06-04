package study.concurrency;

public class BiCounter {
    private int i;
    private int j;

    synchronized public void incrementI(){
        i++;
    }
    synchronized public void incrementJ(){
        j++;
    }


    // Only one thread can be running on all the synchronized code on an instance - significant performance impact


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
