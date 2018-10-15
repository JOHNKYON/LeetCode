package questions.leetcode424;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int[] letters = new int[26];
        int left = 0;
        int right = 0;
        int max_count = 0;

        for (; right<s.length(); right++) {
            max_count = Math.max(max_count, ++letters[s.charAt(right)-'A']);
            while (right - left + 1 - max_count > k) {
                letters[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res, right-left+1);
        }

        return res;
    }
}
