package questions.leetcode402;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k-- > 0) {
            int i=0;
            int len = sb.length();
            for (i=0; i<len-1; i++) {
                if (sb.charAt(i+1) < sb.charAt(i)) {
                    sb.deleteCharAt(i);
                    break;
                }
            }
            if (i == len-1 && i>= 0)
                sb.deleteCharAt(i);
        }
        int i=0;
        while (i<sb.length() && sb.charAt(i) == '0')
            i++;
        if (i == sb.length())
            return "0";
        String ans = sb.substring(i, sb.length());
        return ans;
    }

    public String removeKdigits2(String num, int k) {
        if (k == num.length())
            return "0";

        char[] chs = num.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<chs.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chs[i]);
            } else {
                while (k > 0 && !stack.isEmpty() && stack.peek() > chs[i]) {
                    stack.pop();
                    k--;
                }
                stack.push(chs[i]);
            }
        }
        while (k-- > 0)
            stack.pop();

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        int i=0;
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
