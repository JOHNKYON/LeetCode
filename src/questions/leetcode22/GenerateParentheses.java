package questions.leetcode22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private List<String> result = new ArrayList<String>();

    public List<String> generateParenthesis(int n){
        /*Use DP to solve the problem*/
        dp(0, 0, n, "");
        return result;
    }

    private void dp(int over, int count, int leftTotal, String s){
        /* Over means the number of left parentheses - right,
        *  Total means there are already total left in the string */
        if (count == leftTotal){
//            There are already n '('
            if (0 == over){
                result.add(s);
            }
            else {
                dp(over - 1, count, leftTotal, s+")");
            }
        } else if (0 == over){
            dp(over + 1, count + 1, leftTotal, s+"(");
        } else {
            dp(over + 1, count + 1, leftTotal, s+"(");
            dp(over - 1, count, leftTotal, s+")");
        }
    }
}
