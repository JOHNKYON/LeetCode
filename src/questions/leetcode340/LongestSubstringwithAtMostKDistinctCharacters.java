package questions.leetcode340;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Smart! Sliding window that always keey k distinct letters in it.
        if (s == null || s.length() == 0)   return 0;

        char[] str = s.toCharArray();
        int len = str.length;
        int[] counts = new int[256];

        int left = 0;
        int right = 0;
        int res = 0;
        int curr_count = 0;

        for (; right<len; right++) {
            if (counts[str[right]] == 0) {
                curr_count++;
            }
            counts[str[right]]++;
            if (curr_count > k) {
                // Move left pointer
                while (--counts[str[left++]] != 0);
                curr_count--;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
