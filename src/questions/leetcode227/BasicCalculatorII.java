package questions.leetcode227;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int num = 0;
        char sign = '+';
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i)-'0';
            }
            if ((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==s.length()-1) {
                if (sign == '+')
                    stack.push(num);
                if (sign == '-')
                    stack.push(-num);
                if (sign == '*')
                    stack.push(stack.pop() * num);
                if (sign == '/')
                    stack.push(stack.pop() / num);
                if (s.charAt(i) == ' ')
                    continue;
                sign = s.charAt(i);
                num = 0;
            }
        }

        for (int i: stack)
            ans += i;
        return ans;
    }
}
