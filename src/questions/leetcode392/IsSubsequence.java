package questions.leetcode392;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (t == null || s.length() > t.length())
            return false;
        if (s.length() == 0)
            return true;

        int ptr1 = 0, ptr2 = 0;
        while (ptr2 < t.length()) {
            if (s.charAt(ptr1) == t.charAt(ptr2))
                ptr1++;
            if (ptr1 == s.length())
                return true;
            ptr2++;
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int next = t.indexOf(cur, idx);
            if (next == -1) return false;
            idx = next + 1;
        }
        return true;
    }
}
