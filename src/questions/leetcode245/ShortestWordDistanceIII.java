package questions.leetcode245;

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ans = words.length;
        if (word1.equals(word2)) {
            int last = -1;
            for (int i=0; i<words.length; i++) {
                if (words[i].equals(word1)) {
                    if (last != -1) {
                        ans = Math.min(ans, i - last);
                    }
                    last = i;
                }
            }
            return ans;
        } else {
            int ptr1 = -1, ptr2 = -1;
            for (int i=0; i<words.length; i++) {
                if (words[i].equals(word1)) {
                    ptr1 = i;
                }
                if (words[i].equals(word2)) {
                    ptr2 = i;
                }
                if (ptr1 != -1 && ptr2 != -1) {
                    ans = Math.min(ans, Math.abs(ptr1 - ptr2));
                }
            }
            return ans;
        }
    }
}
