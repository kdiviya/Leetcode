package org.example;

import java.util.Arrays;
import java.util.Stack;

/*Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Leetcode - https://leetcode.com/problems/daily-temperatures/description/
Solution - https://neetcode.io/solutions/daily-temperatures
*/
public class DailyTemperatures {
    public int[] dailyTemp(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) { //compare the temperature
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i); //contains indices for Array.
        }

        return answer;

    }
    public static void main(String[] args) {
        DailyTemperatures obj= new DailyTemperatures();
        System.out.println(Arrays.toString(obj.dailyTemp(new int[] {30,40,50,60})));

    }
}