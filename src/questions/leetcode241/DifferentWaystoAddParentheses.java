package questions.leetcode241;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    List<Integer>[][] memo;
    List<Integer> nums;
    List<Character> ops;
    public List<Integer> diffWaysToCompute(String input) {
        nums = new ArrayList<>();
        ops = new ArrayList<>();
        int val = 0;
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                val = val * 10 + c - '0';
            } else {
                nums.add(val);
                ops.add(c);
                val = 0;
            }
        }
        nums.add(val);
        int len = nums.size();
        List<Integer> ans = new ArrayList<>();
        if (len == 0)
            return ans;
        memo = new ArrayList[len][len];
        for (int i=0; i<len; i++) {
            memo[i][i] = new ArrayList<Integer>();
            memo[i][i].add(nums.get(i));
        }

        return dp(0, len-1);
    }

    private List<Integer> dp(int start, int end) {
        if (memo[start][end] != null)
            return memo[start][end];
        List<Integer> temp = new ArrayList<>();
        for (int i=start; i<end; i++) {
            List<Integer> left = dp(start, i);
            List<Integer> right = dp(i+1, end);
            char op = ops.get(i);
            for (int l: left) {
                for (int r: right) {
                    switch(op){
                        case '+':
                            temp.add(l+r);
                            break;
                        case '-':
                            temp.add(l-r);
                            break;
                        case '*':
                            temp.add(l * r);
                    }
                }
            }
        }
        memo[start][end] = temp;
        return temp;
    }
}
