package questions.leetcode20;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s){
        /*Use a stack can solve the problem very easily*/
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> left = new HashMap<Character, Integer>(){{
            put('(', 0);
            put('[', 1);
            put('{', 2);
        }};
        Map<Character, Integer> right = new HashMap<Character, Integer>(){{
            put(')', 0);
            put(']', 1);
            put('}', 2);
        }};

        for (int i = 0; i < s.length(); i++){
            if (left.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if (right.containsKey(s.charAt(i))){
                if (stack.isEmpty()){
                    return false;
                } if (! left.get(stack.pop()).equals( right.get(s.charAt(i)))){
                    return false;
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
