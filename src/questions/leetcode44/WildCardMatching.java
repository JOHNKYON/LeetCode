package questions.leetcode44;

public class WildCardMatching {
    private Boolean[][] match;

    public boolean isMatch(String s, String p){
        match = new Boolean[s.length()+1][p.length()+1];
        return dp(s, p, 0, 0);
    }

    private boolean dp(String s, String p, int i, int j){
        if (null != match[i][j]){
            return match[i][j];
        }
        boolean res;
        if (j == p.length() || i == s.length()){
            if (j == p.length()){
                res = (i == s.length());
            } else {
                res = true;
                for (int k = j; k < p.length(); k++){
                    if ('*' != p.charAt(k)){
                        res = false;
                    }
                }
            }
        }
        else{
            if (j < p.length() && p.charAt(j) == '*'){
                res = (dp(s, p, i, j+1) || dp(s, p, i+1, j) || dp(s, p, i+1, j+1));
            } else {
                res = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'))
                        && dp(s, p, i+1, j+1);
            }
        }
        match[i][j] = res;
        return res;
    }
}
