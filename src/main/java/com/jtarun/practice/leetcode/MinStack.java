package com.jtarun.practice.leetcode;

import java.util.Stack;

/** 155
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

// Using 1 stack
class MinStack{
    Stack<Long> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(new Long(x));
        } else {
            if (x >= min) {
                stack.push(new Long(x));
            } else {
                Long v = new Long(x);
                v = 2 * v - min;
                stack.push(v);
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        Long t = stack.pop();
        if (t < min) {
            min = (int)(new Long(2 * min) - t);
        }
    }

    public int top() {
        Long t = stack.peek();

        int top;
        if (t >= min) {
            top = t.intValue();
        } else {
            top = min;
        }

        return top;
    }

    public int getMin() {
        return min;
    }
}


// Using 2 stacks
class MinStack2 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty())minStack.push(x);
        else minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}