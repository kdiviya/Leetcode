package org.example;

import java.util.Arrays;

/*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Solution Link -> https://neetcode.io/solutions/contains-duplicate */

public class ContainsDuplicate {

        public boolean containsDuplicate(int[] nums) {
            //Sort the num array
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));

            //Loop over the nums arrays and compare the numbers
            for(int i=0; i<nums.length-1; i++) {
                if(nums[i] == nums[i+1])
                    return true;
            }
          return false;
        }

        public static void main(String[] args) {
            int[] nums = {1,2,3,2};
            ContainsDuplicate s = new ContainsDuplicate();
            System.out.println(s.containsDuplicate(nums));
        }
    }

