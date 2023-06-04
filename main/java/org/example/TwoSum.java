package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {
    /**
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.


    Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
     **/
    public static void main(String[] args) {
        int inputNums1[] = new int[]{2,7,11,15};
        int target1 = 9;
        System.out.println("output for target value " + target1 + " is at the index " + twoSumFunctionUsingMap(inputNums1, target1).toString() );

        int inputNums2[] = new int[]{3,2,4};
        int target2 = 6;
        System.out.println("output for target value " + target2 + " is at the index " + twoSumFunctionUsingMap(inputNums2, target2).toString() );


        int inputNums3[] = new int[]{3,3};
        int target3 = 6;
        System.out.println("output for target value " + target3 + " is at the index " + twoSumFunctionUsingMap(inputNums3, target3).toString() );

    }

    public static int[] twoSumFunction(int[] nums, int target) {
        int firstNum, secondNum;
        int firstNumIndex = 0, secondNumIndex = 0;
        boolean isCombinationFound = false;
        for (int i = 0; i < nums.length; i++) {
            firstNum = nums[i];
            secondNum = target - firstNum;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == secondNum) {
                    firstNumIndex = i;
                    secondNumIndex = j;
                    isCombinationFound = true;
                    break;
                }
            }
            if (isCombinationFound == true) {
                return new int[]{firstNumIndex, secondNumIndex};
            }
        }
        System.out.println("Combination not found");
        return null;
    }
    public static int[] twoSumFunctionUsingMap(int[] nums, int target) {

        Map<Integer,Integer> mapOfNums = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            mapOfNums.put(nums[index],index);
        }

        for (int index = 0; index < nums.length; index++) {
            int secondNumber = target - nums[index];
            if(mapOfNums.containsKey(secondNumber) && mapOfNums.get(secondNumber)!=index){
                return new int []{index,mapOfNums.get(secondNumber)};
            }
        }
        System.out.println("Combination not found");
        return null;
    }
}
