package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Solution Link  -> https://neetcode.io/solutions/product-of-array-except-self */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        List<Integer> prodArr = new ArrayList<>();

        //Iterate over the nums array
        for(int i =0; i<nums.length; i++) {
            int product = 1;

            for(int j=0; j<=nums.length-1; j++) {
                if(i != j) { //exclude the nums[i]
                    product *= nums[j];
                }

            }
            prodArr.add(product);
        }

        //create a fixed size array
        int[] result = new int[nums.length];

        //iterate over the nums and get the values from the prodArr ArrayList
        for(int count=0; count<nums.length; count++) {
            result[count] = prodArr.get(count);
        }
        return result;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf m = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(m.productExceptSelf(new int[] {0,0})));
    }
}