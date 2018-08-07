package questions.leetcode394;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i=0;
        String res = "";
        String digit_str = "";
        while(i<s.length()){
            char c = s.charAt(i);
            if (c != ']'){
                if (c - '0' <= 10){
                    digit_str = digit_str + c;
                } else{
                    if (c == '['){
                        stack.push(digit_str);
                        digit_str = "";
                    }
                    stack.push(""+c);
                }
            } else{
                String sub_string = "";
                String temp = stack.pop();
                while(!temp.equals("[")){
                    sub_string = temp + sub_string;
                    temp = stack.pop();
                }
                int count = Integer.parseInt(stack.pop());
                String repeated_sub_string = "";
                while (count > 0){
                    repeated_sub_string += sub_string;
                    count--;
                }
                stack.push(repeated_sub_string);
            }
            i++;
        }

        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }

        return res;
    }
}
