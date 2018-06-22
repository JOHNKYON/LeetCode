package questions.leetcode224;

import java.util.Stack;

public class BasicCalculator {
    Stack<Character> charStack;
    Stack<Integer> numStack;

    public int calculate(String s) {
        charStack = new Stack<>();
        numStack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ') i++;

            else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
                charStack.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) == ')') {
                charStack.pop();

                while (!charStack.isEmpty() && charStack.peek() != '(') {
                    cal();
                }
                i++;
            } else {
                int num = 0;
                while (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numStack.push(num);
                if (!charStack.isEmpty() && (charStack.peek() == '+' || charStack.peek() == '-'))
                    cal();
            }
        }
        return numStack.pop();
    }

    private void cal(){
        char calculator = charStack.pop();

        int right = numStack.pop();
        int left = numStack.pop();

        if (calculator == '+') numStack.push(left + right);
        else numStack.push(left-right);
    }
}
