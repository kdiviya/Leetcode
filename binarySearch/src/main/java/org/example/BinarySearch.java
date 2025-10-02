package org.example;

/*Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Leetcode - https://leetcode.com/problems/binary-search/description/
Solution - https://neetcode.io/solutions/binary-search*/

public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0;
        int length = nums.length-1;

        while(i <= length)  {
            int index = i + ((length - i)/2);

            if(target == nums[index]) {
                return index;
            }
            else if(target > nums[index]) {
                i = index + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.search(new int[] {-1,0,3,5,9,12}, 9));
    }
}