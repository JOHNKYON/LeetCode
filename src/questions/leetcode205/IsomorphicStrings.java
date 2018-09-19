package questions.leetcode205;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        int[] to = new int[128];
        int[] from = new int[128];

        int len = s.length();
        for (int i=0; i<len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ((to[sc] == 0 && from[tc] == 0)){
                to[sc] = tc;
                from[tc] = sc;
                continue;
            }
            else{
                if (to[sc] == tc && from[tc] == sc)
                    continue;
                else
                    return false;
            }
        }

        return true;
    }
}
