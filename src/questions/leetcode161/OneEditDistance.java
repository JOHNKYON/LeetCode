package questions.leetcode161;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        if (s.length() - t.length() > 1 || s.equals(t))
            return false;
        for (int i=0; i<t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length())
                    return s.substring(i+1).equals(t.substring(i+1));
                else
                    return s.substring(i+1).equals(t.substring(i));
            }
        }
        return true;
    }
}
