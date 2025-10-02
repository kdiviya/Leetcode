package org.example;

/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Input: piles = [3,6,7,11], h = 8
Output: 4
Leetcode -  https://leetcode.com/problems/koko-eating-bananas/description/
Solution -  https://neetcode.io/solutions/koko-eating-bananas */

import java.util.Arrays;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); //find the maximum element in the pile

        while(left < right) {
            int totHours = 0;
            int mid = left + (right -left) / 2; //find the mid element

            for(int pile : piles) {
                totHours += Math.ceil((double) pile / mid);
            }

            if(totHours > h) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        KokoEatingBanana obj = new KokoEatingBanana();
        System.out.println(obj.minEatingSpeed(new int[] {3,6,7,11}, 8));

    }
}