package questions.leetcode247;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    List<String> res;

    static char[][] dict_even = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    static char[] dict_odd = {'0','1','8'};

    public List<String> findStrobogrammatic(int n) {

        res = new ArrayList<>();
        if (n == 0)
            return res;

        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }

        StringBuilder sb = new StringBuilder();

        if ((n & 1) == 1) {
            for (char c: dict_odd) {
                sb.append(c);
                build(sb, n-1);
                sb.deleteCharAt(0);
            }
        } else
            build(sb, n);

        return res;
    }

    private void build(StringBuilder sb, int n) {
        if (n == 0)
            res.add(sb.toString());
        else {
            int i=0;
            if (n == 2)
                i++;
            for (; i<dict_even.length; i++) {
                sb.insert(0, dict_even[i][0]);
                sb.append(dict_even[i][1]);
                build(sb, n-2);
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return;
    }

    static char[] self = {
            '0',
            '1',
            '8'
    };

    static char[][] changePairs = {
            {'6','9'},
            {'9','6'}
    };
    public List<String> findStrobogrammatic2(int n) {
        char[] chars = new char[n];
        int left = (n-1)/2;
        int right = n / 2;
        List<String> ans = new ArrayList<>();
        buildString(chars, left, right, ans);
        return ans;
    }

    private void buildString(char[] chars, int left, int right, List<String> ans) {
        if (left < 0) {
            ans.add(new String(chars));
            return;
        }
        for (char c: self) {
            if (left == 0 && c == '0' && chars.length != 1)
                continue;
            chars[left] = c;
            chars[right] = c;
            buildString(chars, left-1, right+1, ans);
        }
        if (left != right) {
            for (char[] pair: changePairs) {
                chars[left] = pair[0];
                chars[right] = pair[1];
                buildString(chars, left-1, right+1, ans);
            }
        }
    }
}
