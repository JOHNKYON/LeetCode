package questions.leetcode301;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    private void remove(String s, List<String> ans, int last_i, int last_j, char[] pars) {
        for (int lefts=0, i=last_i; i<s.length(); i++) {
            if (s.charAt(i) == pars[0]) lefts++;
            if (s.charAt(i) == pars[1]) lefts--;
            if (lefts >=0)  continue;
            for (int j=last_j; j<=i; j++) {
                if (s.charAt(j) == pars[1] && (j == last_j || s.charAt(j-1) != pars[1])) {
                    remove(s.substring(0, j) + s.substring(j+1, s.length()), ans, i, j, pars);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pars[0] == '(')
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else
            ans.add(reversed);
    }
}
