package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 *
 * Input Format: N = 5
 *
 * Result:
 * 00100
 * 01 100
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 *
 * Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.
 * 
 * 
 * 
 * Example 2:
 *
 * Input Format: N = 1
 *
 * Result: 
 *     1
 */
public class PascalsTriangle {
    public static void main(String[] args) {

        drawPascalsTriangle(10);
        
    }
    
    public static void drawPascalsTriangle(int rows){
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer>currentRow = null, previousRow = null;

        for (int i = 0; i < rows; i++) {
            currentRow = new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                if (j==0 || j==i){
                    currentRow.add(1);
                }
                else{
                    currentRow.add(previousRow.get(j-1)+previousRow.get(j));
                }
            }
            returnList.add(currentRow);
            previousRow = currentRow;

        }

        System.out.println(returnList.toString());
        
    }
}
