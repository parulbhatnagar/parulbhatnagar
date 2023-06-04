package org.example;

public class MedianTwoSortedArrays {


    public static void main(String[] args) {
        int[] nums11 = {1};
        int[] nums12 = {2,3,4};
        System.out.println("median for testcase 1_0 is " + findMedianSortedArrays(nums11, nums12));

/*
        int[] nums21 = {3};
        int[] nums22 = {1,2};
        System.out.println("median for testcase 2_0 is " + findMedianSortedArrays(nums21, nums22));

       int[] nums11_1 = {1, 2};
        int[] nums12_1 = {3, 4};
        System.out.println("median for testcase 1 is " + findMedianSortedArrays(nums11_1, nums12_1));

        int[] nums21_2 = {1, 3};
        int[] nums22_2 = {2};
        System.out.println("median for testcase 2 is " + findMedianSortedArrays(nums21_2, nums22_2));

        int[] nums31 = {1};
        int[] nums32 = {2};
        System.out.println("median for testcase 3 is " + findMedianSortedArrays(nums31, nums32));

        int[] nums41 = {1, 2, 3};
        int[] nums42 = {};
        System.out.println("median for testcase 4 is " + findMedianSortedArrays(nums41, nums42));
        System.out.println("median for testcase 5 is " + findMedianSortedArrays(nums42, nums41));
        System.out.println("median for testcase 6 is " + findMedianSortedArrays(nums42, nums42));


        int[] nums51 = {1, 2};
        int[] nums52 = {};
        System.out.println("median for testcase 7 is " + findMedianSortedArrays(nums51, nums52));
        System.out.println("median for testcase 8 is " + findMedianSortedArrays(nums52, nums51));
        System.out.println("median for testcase 9 is " + findMedianSortedArrays(nums52, nums52));

        int[] nums61 = {1};
        int[] nums62 = {};
        System.out.println("median for testcase 10 is " + findMedianSortedArrays(nums61, nums62));
        System.out.println("median for testcase 11 is " + findMedianSortedArrays(nums62, nums61));
        System.out.println("median for testcase 12 is " + findMedianSortedArrays(nums62, nums62));*/
    }

    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * <p>
     * The overall run time complexity should be O(log (m+n)).
     * <p>
     * Example 1:
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     * <p>
     * Constraints:
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int targetSortedIndex = (nums1.length + nums2.length) / 2;
        boolean isMeanAverageOfTwoNumber = (nums1.length + nums2.length) % 2 == 0 ? true : false;

        //boundary conditions of one of the array being null
        if (nums1.length == 0 && nums2.length != 0) {
            if (nums2.length % 2 == 1) {
                return (double) nums2[nums2.length / 2];
            } else {
                if ((nums2.length / 2) - 1 >=0) {
                    return (double) (nums2[nums2.length / 2] + nums2[(nums2.length / 2) - 1]) / 2;
                }
                else{
                    return (double) nums2[nums2.length / 2];
                }
            }
        } else if (nums1.length != 0 && nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                return (double) nums1[nums1.length / 2];
            } else {
                if ((nums1.length / 2) - 1 >=0){
                    return (double) (nums1[nums1.length / 2] + nums1[(nums1.length / 2) - 1]) / 2;
                }
                else{
                    return (double) nums1[nums1.length / 2];
                }

            }
        } else if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        return getMedianNumber(false,nums1, 0, false,nums2, 0, targetSortedIndex, isMeanAverageOfTwoNumber);

    }

    private static double getMedianNumber(boolean isNum1Exhuasted,
                                          int[] nums1,
                                          int startIndex1,
                                          boolean isNum2Exhuasted,
                                          int[] nums2,
                                          int startIndex2,
                                          int targetSortedIndex,
                                          boolean isMeanAverageOfTwoNumber) {
        if (startIndex1 + startIndex2 + 1 >= targetSortedIndex) {
            //Logic to return value
            if (isMeanAverageOfTwoNumber == true) {
                // num1.st-1 , num1.st , num2.st-1 , num2.st
                if (nums1[startIndex1] > nums2[startIndex2]) {
                    if (startIndex2+1 < nums2.length &&
                            nums1[startIndex1]>nums2[startIndex2+1]){
                        return (double) (nums2[startIndex2] + nums2[startIndex2 + 1]) / 2;
                    }
                    else {
                        if(isNum1Exhuasted){
                            return (double) (nums2[startIndex2] + nums2[startIndex2 - 1]) / 2;
                        }
                        else {
                            return (double) (nums2[startIndex2] + nums1[startIndex1]) / 2;
                        }
                    }
/*                    if (startIndex1 - 1 < 0 || nums2[startIndex2] > nums1[startIndex1 - 1]) {
                        return (double) (nums1[startIndex1] + nums2[startIndex2]) / 2;
                    } else {
                        return (double) (nums1[startIndex1] + nums1[startIndex1 - 1]) / 2;
                    }*/
                } else if (nums2[startIndex2] > nums1[startIndex1]) {
                    if (startIndex1+1 < nums1.length &&
                            nums2[startIndex2]>nums1[startIndex1+1]){
                        return (double) (nums1[startIndex1] + nums1[startIndex1 + 1]) / 2;
                    }
                    else {
                        return (double) (nums2[startIndex2] + nums1[startIndex1]) / 2;
                    }

/*                    if (startIndex2 - 1 < 0 &&
                    nums2[startIndex2]>nums1[startIndex1-1])
                    if (startIndex2 - 1 < 0 || nums1[startIndex1] > nums2[startIndex2 - 1]) {
                        return (double) (nums2[startIndex2] + nums1[startIndex1]) / 2;
                    } else {
                        return (double) (nums2[startIndex2] + nums2[startIndex2 - 1]) / 2;
                    }*/
                } else { // both values are equal
                    return nums1[startIndex1];
                }
            } else {
                if (nums1[startIndex1] > nums2[startIndex2]){
                    if (startIndex2+1 < nums2.length &&
                            nums1[startIndex1]>nums2[startIndex2+1]){
                        return nums2[startIndex2+1];
                    }
                    else {
                        return nums1[startIndex1];
                    }
                }
                else{
                    if (startIndex1+1 < nums1.length &&
                            nums2[startIndex2]>nums1[startIndex1+1]){
                        return nums1[startIndex1+1];
                    }
                    else {
                        return nums2[startIndex2];
                    }
                }
            }
        } else {
            // recursive call by moving relevant start index
            if (nums1[startIndex1] < nums2[startIndex2]) {
                if (startIndex1 + 1 < nums1.length) {
                    return getMedianNumber(false, nums1, startIndex1 + 1, false,nums2, startIndex2, targetSortedIndex, isMeanAverageOfTwoNumber);
                } else {
                    //index1 has finished keep incrementing index2
                    return getMedianNumber(true,nums1, startIndex1, false, nums2, startIndex2 + 1, targetSortedIndex, isMeanAverageOfTwoNumber);
                }
            } else {
                if (startIndex2 + 1 < nums2.length) {
                    return getMedianNumber(false,nums1, startIndex1, false,nums2, startIndex2 + 1, targetSortedIndex, isMeanAverageOfTwoNumber);
                } else {
                    return getMedianNumber(false,nums1, startIndex1 + 1, true,nums2, startIndex2, targetSortedIndex, isMeanAverageOfTwoNumber);
                }
            }
        }
    }
}
