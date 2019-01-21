package questions.leetcode716;

import java.util.*;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty()? x: maxStack.peek();
        maxStack.push(max > x? max: x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> temp = new Stack<>();
        int max = peekMax();
        while (top() != max) {
            temp.push(pop());
        }
        pop();
        while (!temp.isEmpty())
            push(temp.pop());
        return max;
    }
}
