package org.example;

import java.util.HashMap;

public class AnagramCheck {
    public static void main(String[] args) {
        String input1 = "race";
        String input2 = "caree";

        HashMap<Character, Integer> comparableStringMap = new HashMap<Character, Integer>();

        for (Integer i=0 ; i <input1.length(); i++) {
            comparableStringMap.put(input1.charAt(i),comparableStringMap.getOrDefault(input1.charAt(i),0)+1);
        }

        for (Integer i=0 ; i <input2.length(); i++) {
            comparableStringMap.put(input2.charAt(i),comparableStringMap.getOrDefault(input2.charAt(i),0)-1);
            if(comparableStringMap.get(input2.charAt(i)) == 0){
                comparableStringMap.remove(input2.charAt(i));
            }
        }
        if (comparableStringMap.isEmpty()){
            System.out.println("Its an anagram");
        }
        else{
            System.out.println("not an anagram");
        }
        
    }
}
