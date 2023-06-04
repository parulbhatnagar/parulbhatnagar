package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Examples 1:
 *
 * Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
 *
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
 *
 * Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 *
 * Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
 * 
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        // first solution comes to mind is, identify is and js list where 
        //then traverse the matrix and set them to 0

        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        matrixSetZero(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    private static void matrixSetZero(int input[][]){
        int rows=input.length, columns = input[0].length;
        int xAxis[] = new int[rows];
        int yAxis[] = new int[columns];

        Arrays.fill(xAxis,-1);
        Arrays.fill(yAxis,-1);

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                if(input[i][j] == 0){
                    xAxis[i]++;
                    yAxis[j]++;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if((xAxis[i] >-1) || (yAxis[j] > -1)){
                    input[i][j]=0;
                }
            }

        }
    }
}
