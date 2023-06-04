package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        final Map<String, List<String>> graph = Map.of("a", Arrays.asList("b","c"),
                "b", Arrays.asList("d"),
                "c", Arrays.asList("e"),
                "d", Arrays.asList("f"),
                "e", Arrays.asList(""),
                "f", Arrays.asList(""));
/*        System.out.println("Breadth first traversal starting at a");
        breadthFirstPrint(graph, "a");

        System.out.println("Depth first traversal starting at a");
        depthFirstPrint(graph, "a");*/

        System.out.println("Decimal number for roman number III = " + romanToDecimal("III"));
        System.out.println("Decimal number for roman number LVIII = " + romanToDecimal("LVIII"));
        System.out.println("Decimal number for roman number MCMXCIV = " + romanToDecimal("MCMXCIV"));
        System.out.println("Decimal number for roman number IX = " + romanToDecimal("IX"));


    }

    private static void breadthFirstPrint(Map<String, List<String>> graph, String start) {
        //Done with queue -> first in first out
        //check if key is present in map or not
        if(graph.containsKey(start)) {
            Queue<String> nodeList = new LinkedList<>();
            nodeList.addAll(graph.get(start));
            System.out.println("The node is : "+ start);
            while (!nodeList.isEmpty()) {
                breadthFirstPrint(graph, nodeList.remove());
            }
        }
        else {
            System.out.println("node not present in the graph");
        }
    }

    private static void depthFirstPrint(Map<String, List<String>> graph, String start) {
        //Done with stack last in first out
        if (graph.containsKey(start)){
            Stack<String> nodeList = new Stack<>();
            nodeList.addAll(graph.get(start));
            System.out.println("the node is :"+start);
            while(!nodeList.isEmpty()){
                depthFirstPrint(graph, nodeList.pop());
            }
        }
        else{
            System.out.println("node not present");
        }

    }
    /**
    Example 1:M

    Input: s = "III"
    Output: 3
    Explanation: III = 3.
    Example 2:

    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.
    Example 3:

    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     **/

    private static int romanToDecimal(String romanNumber){
        if (romanNumber.isEmpty()
        || romanNumber.length()>15){
            System.out.println("Invalid input");
        }

        final Map<String, Integer> romanTodecimalMap = Map.of("I",1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D",500,
                "M",1000);
        var prevDecimalValue = 0;
        var returnValue = 0;
        for(int i=romanNumber.length()-1; i>=0;i--){
            Integer decimalValue = romanTodecimalMap.get(String.valueOf(romanNumber.charAt(i)));
            if (decimalValue.intValue()<prevDecimalValue){
                returnValue -= decimalValue.intValue();
            }
            else{
                returnValue+= decimalValue.intValue();
            }
            prevDecimalValue = decimalValue.intValue();
        }
        return returnValue;
    }


    private static String LongestCommonPrefix(String[] strs) {



        return null;

    }
}