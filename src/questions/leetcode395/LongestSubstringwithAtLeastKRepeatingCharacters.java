package questions.leetcode395;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int ans = 0;
        char[] str = s.toCharArray();
        for (int i=0; i<n; i++) {
            int[] count = new int[26];
            for (int j=i; j<n; j++) {
                int idx = str[j] - 'a';
                count[idx]++;
                if (count[idx] >= k && valid(count, k)) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }

    private boolean valid(int[] count, int k) {
        for (int n: count) {
            if (n != 0 && n < k) {
                return false;
            }
        }
        return true;
    }
}
