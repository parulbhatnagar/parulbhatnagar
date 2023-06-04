package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RocksInTheBag {

    public static void main(String[] args) {
        int capacity[]={2,3,4,5};
        int rocks[]={1,2,4,4};
        int numberOfRocks=2;
        System.out.println("number of bags full = " +
                maximumBags(capacity,rocks,numberOfRocks));
    }
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> deficit = new ArrayList<>();
        for (int index = 0; index < capacity.length; index++) {
            deficit.add(capacity[index]- rocks[index]);
        }
        Collections.sort(deficit);
        Integer sum = 0;
        int bagsFull = 0;
        for (int i :
                deficit) {
            sum+=i;
            bagsFull++;
            if (sum >additionalRocks)
            {
                bagsFull--;
                break;
            }
        }
        return bagsFull;
    }
}
