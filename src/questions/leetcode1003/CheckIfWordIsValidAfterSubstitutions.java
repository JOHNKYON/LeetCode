package questions.leetcode1003;

public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        int split = S.indexOf("abc");
        while (split != -1) {
            String x = S.substring(0, split);
            String y = S.substring(split+3, S.length());
            S = x + y;
            split = S.indexOf("abc");
        }
        return S.length() == 0;
    }
}
