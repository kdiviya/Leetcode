package org.example;

import java.util.HashSet;
import java.util.Set;

/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Solution Link -> https://neetcode.io/solutions/longest-consecutive-sequence */

public class LongestConsecutiveSequence {

    public int longestSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longest = 0;

        //Add the nums[] to hashSet which store unique numbers
        for(int num : nums) {
            numSet.add(num);
        }

        for(int num : numSet) {
            //Check the start of sequence (before the number)
            if(!numSet.contains(num-1)) {
                int currentNo = num; // Assign the current number if it is the start of sequence
                int count = 1;
                while(numSet.contains(currentNo+1)) { //Iterate over the numSet until the sequence ends.
                    currentNo++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }
        return longest;

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence m =  new LongestConsecutiveSequence();
        System.out.println(m.longestSequence(new int[] {4,100,200,2,3,1}));

    }
}