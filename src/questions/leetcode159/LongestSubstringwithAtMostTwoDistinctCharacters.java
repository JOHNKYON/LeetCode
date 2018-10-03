package questions.leetcode159;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] counts = new int[256];

        int distinct = 0;
        int left = 0;
        int res = 0;

        for (int right=0; right<s.length(); right++) {
            if (counts[s.charAt(right)]++ == 0) {
                distinct++;
            }

            if (distinct > 2) {
                while (--counts[s.charAt(left++)] != 0);
                distinct--;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
