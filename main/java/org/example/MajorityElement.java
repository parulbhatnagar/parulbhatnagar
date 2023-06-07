package org.example;

import java.util.HashMap;

public class MajorityElement {

    // Given an integer array of size "n" find all the elements that appear more then n/3 times

    public static void main(String[] args) {

        Integer[] integers = {1,3,2,5,1,3,1,5,1,3,3,4,5};

        Integer majorityNumber = integers.length / 3;

        HashMap<Integer,Integer> record = new HashMap<>();

        for (Integer i :
                integers) {
/*            if (!record.containsKey(i)){
                record.put(i,1);
            }
            else{
                record.put(i,record.get(i)+1);
            }*/
            record.put(i,record.getOrDefault(i,0)+1);
        }
        System.out.println("Majority number is = " + majorityNumber);

        for (Integer key :
                record.keySet()) {
            if(record.get(key)>= majorityNumber){
                System.out.println(key + "->" + record.get(key));
            }
        }

    }
}
