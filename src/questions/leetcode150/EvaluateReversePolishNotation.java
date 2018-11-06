package questions.leetcode150;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {
            int a = 0;
            int b = 0;
            int curr = 0;
            switch(token) {
                case "+":
                    curr = stack.pop() + stack.pop();
                    break;
                case "*":
                    curr = stack.pop() * stack.pop();
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    curr = a - b;
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    curr = a / b;
                    break;
                default:
                    curr = Integer.parseInt(token);
                    break;
            }
            stack.push(curr);
        }
        return stack.pop();
    }
}
