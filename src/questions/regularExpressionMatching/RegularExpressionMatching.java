package questions.regularExpressionMatching;

/**
 * Created by JOHNKYON on 2018/3/28.
 * This is a solution to LeetCode Questions.
 */
public class RegularExpressionMatching {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p){
        /*s is the string and p is the pattern (regular expression)*/
        memo = new Boolean[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p){
        if (null != memo[i][j]){
            return memo[i][j];
        }
        boolean ans;
        if (j == p.length()){
            ans = (i == s.length());
        } else {
            boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || '.' == p.charAt(j)));
            if (j+1 < p.length() && '*' == p.charAt(j+1)){
                ans = (dp(i, j+2, s, p) ||          // '*' matches 0 times
                        (firstMatch && dp(i+1, j, s, p)));
            } else {
                ans = firstMatch && dp(i+1, j+1, s, p);
            }
        }
        memo[i][j] = ans;
        return ans;
    }
}
