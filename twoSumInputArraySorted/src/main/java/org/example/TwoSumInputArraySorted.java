package org.example;

/*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Leetcode -> https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
Solution Link -> https://neetcode.io/solutions/two-sum-ii-input-array-is-sorted */

import java.util.Arrays;

public class TwoSumInputArraySorted {

    public int[] twoSum(int[] numbers, int target) {

        for(int i=0; i<numbers.length; i++) {

            for(int j=i+1; j<numbers.length; j++) {
                int result = numbers[i] + numbers[j]; //Add the consecutive numbers and compare with the target
                if (result == target) {
                    return new int[] {i+1,j+1};
                }
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSumInputArraySorted obj = new TwoSumInputArraySorted();
        System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15},9 )));

    }
}