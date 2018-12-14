package questions.leetcode859;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2)
            return false;

        int[] pos = new int[2];
        int curr = 0;
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (curr > 1)
                    return false;
                pos[curr++] = i;
            }
        }
        if (curr != 2 && curr != 0)
            return false;
        if (curr == 2) {
            if (A.charAt(pos[0]) == B.charAt(pos[1]) &&
                    A.charAt(pos[1]) == B.charAt(pos[0]))
                return true;
            return false;
        } else {
            int[] chs = new int[26];
            for (char c: A.toCharArray()) {
                if (++chs[c-'a'] == 2)
                    return true;
            }
            return false;
        }
    }
}
