package org.example;

import java.util.HashMap;
import java.util.Set;

public class StudyHash {

    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();

        hashMap.put("India", 100);
        hashMap.put("China",150);
        hashMap.put("US",50);

        System.out.println(hashMap);


        System.out.println("Population of India is " + hashMap.get("India"));
        System.out.println("Population of Mexico is " + hashMap.get("Mexico"));


        System.out.println( "Contains key India " + hashMap.containsKey("India"));
        System.out.println( "Contains key India " + hashMap.containsKey("Mexico"));

        System.out.println("Remove China " + hashMap.remove("China"));

        System.out.println(hashMap);

        Set<String> keys = hashMap.keySet();

        System.out.println(keys);

        for (String key :
                keys) {
            System.out.println(key + "->" +hashMap.get(key));
        }



    }
}
