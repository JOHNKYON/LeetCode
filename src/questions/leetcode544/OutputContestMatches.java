package questions.leetcode544;

public class OutputContestMatches {
    public String findContestMatch(int n) {
        String[] strs = new String[n];
        for (int i=0; i<n; i++) {
            strs[i] = Integer.toString(i+1);
        }

        return match(strs)[0];
    }

    private String[] match(String[] strs) {
        if (strs.length == 1)
            return strs;
        String[] new_strs = new String[strs.length/2];
        int n = new_strs.length;
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(strs[i]);
            sb.append(',');
            sb.append(strs[2*n-i-1]);
            sb.append(')');
            new_strs[i] = sb.toString();
        }
        return match(new_strs);
    }
}
