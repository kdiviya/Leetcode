package org.example;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
Leetcode -> https://leetcode.com/problems/min-stack/description/
Solution Link -> https://neetcode.io/solutions/min-stack */

import java.util.Stack;

public class MinStack {
    long min;
    Stack<Long> stack;

    //initailize the stack variable
    public MinStack() {
         stack =  new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L); //if the stack is empty, push 0 onto the stack because min and value are same
            min = val;
        }
        else {
            stack.push(val - min); //find the difference
            if(val < min) min = val;  // if the value is lesser than min, set the val to minimum.
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long pop = stack.pop();
        if(pop < 0) { // set the min value if the popped element is negative.
            min = min - pop;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min); //return the real value not the difference
        }
        else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("Minimum value: " + obj.getMin());
        obj.pop();
        System.out.println("Top value: " + obj.top());
        System.out.println("Minimum value: " + obj.getMin());

    }
}