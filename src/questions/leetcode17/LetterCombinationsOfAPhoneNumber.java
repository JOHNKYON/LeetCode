package questions.leetcode17;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JOHNKYON on 2018/3/30.
 * This is a solution to LeetCode Questions.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (0 == digits.length()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String temp = ans.remove();
                for (Character c : mapping[x].toCharArray()) {
                    ans.add(temp + c);
                }
            }
        }
        return ans;
    }
}
