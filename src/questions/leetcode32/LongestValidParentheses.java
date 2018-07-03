package questions.leetcode32;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;

        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                } else {
                    int temp = i - stack.peek();
                    res = (res > temp)? res:temp;
                }
            }
        }
        return res;
    }
}
