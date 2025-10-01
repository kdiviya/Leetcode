package org.example;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Leetcode - https://leetcode.com/problems/generate-parentheses/description/
Soultion  - https://neetcode.io/solutions/generate-parentheses */

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    public List<String> genParantheses(int n) {
        List<List<String>> res = new ArrayList<>();
        for(int i= 0; i<=n; i++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add("");

        for(int k=0; k<=n; k++) {
            for(int i=0; i<k; i++) {
                for(String left : res.get(i)) {
                    for(String right : res.get(k-i-1)) {
                        res.get(k).add("(" + left + ")" +right);
                    }
                }
            }
        }
        return res.get(n);

    }
    public static void main(String[] args) {
        GenerateParantheses obj = new GenerateParantheses();
        System.out.println(obj.genParantheses(3));

    }
}