package org.example;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

    // 25148
    // 2514 (pivot)8
    // 25184 (swap/reverse)

    // 251(pivot)84
    // 254 8 1(Swap pivot and next closet number in substring
    // 25418 (reverse the substring)
    // 2541(pivot)8
    // 25481 (swap reverse)
    // 254(pivot)81
    // 25 8 4 1 (swap)
     // 25814 (reverse sub string)



    // 25184
    // 25(pivot) 418

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(2);input.add(5);input.add(1);
        System.out.println("Next permutation is : " + nextPermutation(input).toString());
    }

    private static List<Integer> nextPermutation(List<Integer> input){
        List<Integer> returnList = new ArrayList<>();

/*        for (int i = 0; i < input.size(); i++) {
            if (input.get(i))

        }*/

        return returnList;

    }
}
