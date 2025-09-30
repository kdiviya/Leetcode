package org.example;

import java.util.Arrays;

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
LeetCode -> https://leetcode.com/problems/two-sum/description/
Solution Link -> https://neetcode.io/solutions/two-sum */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        //Iterate over the nums array and compare 2 numbers with target
        for(int i =0; i<=nums.length-1; i++) {

            for(int j=i+1; j<=nums.length-1;j++) {
                if(nums[i] + nums[j]== target) {
                    return new int[]{i,j};
                }
            }

        }
        return new int[] {};
    }
    public static void main(String[] args) {
        TwoSum m = new TwoSum();
        System.out.println(Arrays.toString(m.twoSum(new int[]{3,3}, 6)));

    }
}