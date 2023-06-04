package org.example;

public class PalindromicSubString {
    public static void main(String[] args) {
        String input="babad";

        System.out.println("ForString :{" + input + "} the biggest sub string is {" + longestPalindrome(input)+"}");

        System.out.println("ForString :{bbbb} the biggest sub string is {" + longestPalindrome("bb")+"}");

    }

//  Approach 1 - Check the number of centers and if string a palindrome or not

    public static String longestPalindromeUsingCenters(String s){
        if(s==null || s.length()<1){
            return "";
        }
        int start=0,end=0;
        String returnString;


        for (int i = 0; i < s.length(); i++) {
            int len1 = getLongestSubstringLengthWithGivenCenter(s,i,i);
            int len2 = getLongestSubstringLengthWithGivenCenter(s,i,i+1);

            int len = Math.max(len1,len2);

            if ((end - start) < len){
                start = i - (len-1)/2;
                end = i + len/2 ;
            }

        }

        return s.substring(start,end+1);
    }

    private static int getLongestSubstringLengthWithGivenCenter(String s, int l, int r) {
        int left = l, right = r;
        int returnLength = 1;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            returnLength = right - left + 1;
            left --;
            right ++;
        }
        return returnLength;
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
/*
    public static String longestPalindrome(String s) {
        String returnString=s.substring(0,1);
        int leftIndex = 0, rightIndex=1;
        String analysisString;
        while(leftIndex<s.length()
        && rightIndex<s.length()){
            analysisString=s.substring(leftIndex,rightIndex+1);

            if (isStringPalindrome(analysisString) && analysisString.length()>returnString.length()) {
                returnString=analysisString;
                rightIndex++;
            }
            else {
                leftIndex++;
                if(leftIndex == rightIndex){
                    rightIndex++;
                }
            }

        }

        return returnString;

    }

    public static boolean isStringPalindrome(String inputString){
        int leftIndex = 0, rightIndex=inputString.length();
        String leftString,rightString;

        leftString = inputString.substring(leftIndex,(leftIndex+(rightIndex-leftIndex)/2));
        StringBuffer tempBuffer = new StringBuffer(inputString.substring(leftIndex+(rightIndex-leftIndex)/2,rightIndex));
        rightString = tempBuffer.reverse().toString();
        if(leftString.equals(rightString)){
            return true;
        } else {
            return false;
        }
    }*/
}
