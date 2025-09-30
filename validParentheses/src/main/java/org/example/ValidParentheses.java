package org.example;

/* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Input: s = "()"
Output: true
Leetcode -> https://leetcode.com/problems/valid-parentheses/description/
Solution Link -> https://neetcode.io/solutions/valid-parentheses */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String str) {
        Stack<Character> bracketStack =  new Stack<>();
        Map<Character, Character> bracketsMap =  new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');
        bracketsMap.put(']', '[');

        for(char c : str.toCharArray()) {
            if(bracketsMap.containsKey(c)) { // validate the brackets against the key and  if key's value is matched with the top element of the stack and removed the element assuring that match is found.
                if(!bracketStack.isEmpty() && (bracketStack.peek() == bracketsMap.get(c))) {
                    bracketStack.pop();
                }
                else {
                    return false;
                }
            }

            else { // if the brackets not found in the map, push the brackets into the stack and check for the closing/opening bracket
                bracketStack.push(c);
            }
        }

        return bracketStack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParentheses obj =  new ValidParentheses();
        System.out.println(obj.isValid("()[]{})"));
    }
}