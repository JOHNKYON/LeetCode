package questions.leetcode583;

public class DeleteOperationforTwoStrings {
    public int minDistance(String word1, String word2) {
        int max = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2+1];
        for (int i=1; i<=len1; i++) {
            int[] next = new int[len2+1];
            for (int j=1; j<=len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    next[j] = dp[j-1] + 1;
                } else {
                    next[j] = Math.max(next[j-1], dp[j]);
                }
            }
            dp = next;
        }

        return word1.length() - 2 * dp[len2] + word2.length();
    }
}
