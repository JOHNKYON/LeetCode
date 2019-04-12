package questions.leetcode131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>>[] memo;
    public List<List<String>> partition(String s) {
        int n = s.length();
        memo = new ArrayList[n];
        return build(s, 0);
    }

    private List<List<String>> build(String s, int start) {
        if (start >= s.length())
            return null;
        if (memo[start] != null)
            return memo[start];
        List<List<String>> res = new ArrayList<>();
        for (int i=start+1; i<=s.length(); i++) {
            if (isPalindrome(s.substring(start, i))) {
                if (i == s.length()) {
                    String str = s.substring(start, i);
                    List<String> curr = new ArrayList<>();
                    curr.add(str);
                    res.add(curr);
                } else {
                    String str = s.substring(start, i);
                    List<List<String>> next = build(s, i);
                    for (List<String> curr: next) {
                        List<String> temp = new ArrayList<>(curr);
                        temp.add(0, str);
                        res.add(temp);
                    }
                }
            }
        }
        memo[start] = res;
        return res;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
