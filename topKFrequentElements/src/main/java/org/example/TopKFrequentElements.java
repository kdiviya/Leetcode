package org.example;


import java.util.*;

/* Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Leetcode -> https://leetcode.com/problems/top-k-frequent-elements/description/
Solution Link  -> https://neetcode.io/solutions/top-k-frequent-elements */

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> numCount = new HashMap<>();

       //Create map with {number, count}
       for(int num : nums) {
           //getOrDefault() used to return the existing value(already in the hashMap) if key is present. Else it returns the default value(second paramter)
           numCount.put(num, numCount.getOrDefault(num,0)+1);
       }

       //convert the map into array list(count, number) to perform sorting in descending order;
        List<int[]> numList =  new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            numList.add(new int[] {entry.getValue(), entry.getKey()});
        }

        //Sort the array list consider the count of numbers
        numList.sort((arr1, arr2) -> arr2[0] - arr1[0]);

        //create array with fixed size of k
        int[] result = new int[k];

        for(int i=0; i<k; i++) {
            result[i] = numList.get(i)[1];
        }

        return result;

    }
    public static void main(String[] args) {
        TopKFrequentElements m =  new TopKFrequentElements();
        System.out.println(Arrays.toString(m.topKFrequent(new int[] {1,1,1,2,2,3}, 2)));

    }
}