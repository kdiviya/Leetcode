package org.example;

/* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Leetcode -> https://leetcode.com/problems/container-with-most-water/description/
Solution Link -> https://neetcode.io/solutions/container-with-most-water */

public class ContainerMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int result = 0;

        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left); //calculate the width between 2 vertical lines
            result = Math.max(result, area);

            if(height[left] <= height[right]) {
                left++;
            }

            else {
                right--;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        ContainerMostWater obj = new ContainerMostWater();
        System.out.println(obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

    }
}