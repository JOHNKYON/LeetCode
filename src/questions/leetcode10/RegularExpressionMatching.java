package questions.leetcode10;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        int ptr1 = s.length() - 1, ptr2 = p.length() - 1;
        while (ptr2 >= 0) {
            char c2 = p.charAt(ptr2);
            if (c2 == '.') {
                if (ptr1 < 0)
                    return false;
                ptr1--;
                ptr2--;
            } else if (c2 != '*') {
                if (ptr1 < 0)
                    return false;
                char c1 = s.charAt(ptr1);
                if (c1 != c2)
                    return false;
                ptr1--;
                ptr2--;
            } else {
                char prev = p.charAt(ptr2-1);
                if (prev == '.') {
                    for (int i=ptr1+1; i>=0; i--) {
                        if (isMatch(s.substring(0, i), p.substring(0, ptr2-1)))
                            return true;
                    }
                    return false;
                }
                else {
                    for (int i=ptr1+1; i>=0; i--) {
                        if (isMatch(s.substring(0, i), p.substring(0, ptr2-1)))
                            return true;
                        if (i > 0 && s.charAt(i-1) != prev)
                            break;
                    }
                    return false;
                }
            }
        }
        if (ptr1 == -1 && ptr2 == -1)
            return true;
        return false;
    }
}
