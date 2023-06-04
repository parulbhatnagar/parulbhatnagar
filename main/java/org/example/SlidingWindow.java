package org.example;

import java.util.Arrays;

public class SlidingWindow {
    /**
     * Given a string s, find the length of the longest
     * substring
     *  without repeating characters.
     *
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * Constraints:
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     * @param
     * @return
     */

    public static void main(String[] args) {
        System.out.println(" max length for abcabcbb is " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println(" max length for bbbbb is " + lengthOfLongestSubstring("bbbbb"));
        System.out.println(" max length for pwwkew is " + lengthOfLongestSubstring("pwwkew"));
        System.out.println(" max length for xyz is " + lengthOfLongestSubstring("xyz"));
        System.out.println(" max length for aab is " + lengthOfLongestSubstring("aab"));
        System.out.println(" max length for abbcde is " + lengthOfLongestSubstring("abbcde"));
        System.out.println(" max length for au is " + lengthOfLongestSubstring("au"));


        int[] input = {-1,2,3,0,-3,9};
        int subArraySize = 2;
        System.out.println("for give array ={ " + Arrays.toString(input)
                + " } and window size ="+subArraySize
        + "\nmax sum of substr =" + maxSumSubArrayGivenFixedSize(input,subArraySize));

        int[] input1 = {6,0,-1,2,1,-3,4};
        int subArraySize1 = 3;
        System.out.println("for give array ={ " + Arrays.toString(input1)
                + " } and window size ="+subArraySize1
                + "\nmax sum of substr =" + maxSumSubArrayGivenFixedSize(input1,subArraySize1));

        int[] input2 = {6,-3,-5,1,2,0,4};
        int subArraySize2 = 4;
        System.out.println("for give array ={ " + Arrays.toString(input2)
                + " } and window size ="+subArraySize2
                + "\nmax sum of substr =" + maxSumSubArrayGivenFixedSize(input2,subArraySize2));

        int[] dynamicWindowInput = {1,7,9,4,3,2};
        int desiredSum = 7;
        System.out.println("for give array ={ " + Arrays.toString(dynamicWindowInput)
                + " } and desired sum ="+desiredSum
                + "\n sub string combination is  =" + Arrays.toString(subArrayForDesiredSum(dynamicWindowInput,desiredSum)));

        int[] dynamicWindowInput1 = {23,1,6,9,15,8};
        int desiredSum1 = 24;
        System.out.println("for give array ={ " + Arrays.toString(dynamicWindowInput1)
                + " } and desired sum ="+desiredSum1
                + "\n sub string combination is  =" + Arrays.toString(subArrayForDesiredSum(dynamicWindowInput1,desiredSum1)));

        int[] dynamicWindowInput2 = {-1,-4,0,5,3,2,1};
        int desiredSum2 = 5;
        System.out.println("for give array ={ " + Arrays.toString(dynamicWindowInput2)
                + " } and desired sum ="+desiredSum2
                + "\n sub string combination is  =" + Arrays.toString(subArrayForDesiredSum(dynamicWindowInput2,desiredSum2)));
    }

        public static int lengthOfLongestSubstring(String s) {
            Integer[] chars = new Integer[128];

            int left = 0;
            int right = 0;

            int res = 0;
            while (right < s.length()) {
                char r = s.charAt(right);

                Integer index = chars[r];
                if (index != null && index >= left && index < right) {
                    left = index + 1;
                }

                res = Math.max(res, right - left + 1);

                chars[r] = right;
                right++;
            }

            return res;
        }

    /*public static int lengthOfLongestSubstring(String s) {

        int returnLength=1;
        int leftIndex = 0;
        //boolean ifAnyCharacterRepeated = false;
        int substringLength = 0;

        for (int rightIndex = leftIndex+1; rightIndex <s.length() ; ) {
            String subString = s.substring(leftIndex,rightIndex);
            substringLength = subString.length();

            if (subString.contains(s.substring(rightIndex,rightIndex+1))){
                // condition met, this is the sub string move left index for next search
                int subStringLength = s.substring(leftIndex, rightIndex).length();
                if (returnLength < subStringLength){
                    returnLength = subStringLength;
                }
                // move left index to the character which is duplicate+1
                leftIndex +=subString.indexOf(s.substring(rightIndex,rightIndex+1))+1;

            }else{
                // continue to move rightIndex
                rightIndex++;
                if (rightIndex>=s.length() && substringLength>=returnLength){
                    returnLength = substringLength+1;
                }
            }
        }
        if (s.length()==0){
            return 0;
        }
        else{
            return returnLength;
        }

    }*/

    // Statically sized sliding window
    // Given an array of integers, find maximum sum  subarray of required size
    
    // boundary conditions, if window size is more than array size
    public static int maxSumSubArrayGivenFixedSize(int[] input, int windowSize){
        int start = 0;
        int returnSum = 0;
        int windowSum = 0;
        for (int index = 0; index < input.length; index++) {
            if((index - start + 1) < windowSize){
                windowSum += input[index];
                continue;
            }else{
                if(start!=0) {
                    windowSum = windowSum - input[start-1] + input[index];
                }else{
                    windowSum += input[index];
                }
                //condition, if satisfies replace the previous found values
                if (returnSum < windowSum){
                    returnSum = windowSum;
                }
                // sliding window size met, move to next window
                start++;
            }
        }
        return returnSum;
    }

    // Dynamic sized sliding window
    // Given an array of positive integers, find the subarrays that add up to a given number

    public static int[] subArrayForDesiredSum(int[] input, int desiredSum){
        int startIndex = 0;
        int sum = 0;
        for (int index = 0; index < input.length && startIndex < input.length; ) {
            if (index == startIndex){
                sum = input[index];
            }
            else {
                sum += input[index];
            }
            //condition
            if(desiredSum==sum){
                //condition met, return the sub array
                if (startIndex == index){
                    return new int[]{input[startIndex]};
                }
                return new int[]{input[startIndex], input[index]};
            }
            else if (desiredSum > sum){
                // we still can move right door
                index++;
                continue;
            }
            else{
                // window is not good slide left door
                sum -= input[startIndex];
                startIndex++;
            }
        }
        return null;
    }
}

