package org.example;

/*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Leetcode - https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
Solution - https://neetcode.io/solutions/evaluate-reverse-polish-notation */

import java.util.Stack;

public class EvalRPN {
    public int reversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if(str.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            }
            else if(str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if(str.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            }
            else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        EvalRPN obj = new EvalRPN();
        System.out.println(obj.reversePolishNotation(new String[] {"2","1","+","3","*"}));
        System.out.println(obj.reversePolishNotation(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}