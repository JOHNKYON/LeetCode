package questions.leetcode467;

public class UniqueSubstringsInWraparoudString {
    int[] memo;
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0)
            return 0;
        if (p.length() == 1)
            return 1;

        memo = new int[26];
        int res = 0;
        int len = 1;
        for (int i=1; i<p.length(); i++) {
            int letter = p.charAt(i-1) - 'a';
            memo[letter] = Math.max(memo[letter], len);
            if ((p.charAt(i) == 'a' && p.charAt(i-1) == 'z') || p.charAt(i) - p.charAt(i-1) == 1) {
                len++;
            } else {
                len = 1;
            }
        }
        if (len != 0) {
            int letter = p.charAt(p.length()-1) - 'a';
            memo[letter] = Math.max(memo[letter], len);
        }
        for (int i=0; i<26; i++) {
            res += memo[i];
        }
        return res;
    }

    private int sum(int len) {
        return (1 + len) * len / 2;
    }
}
