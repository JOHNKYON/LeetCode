package questions.leetcode819;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban_set = new HashSet<>();

        HashMap<String, Integer> count_map = new HashMap<>();
        for (String word: banned) {
            ban_set.add(word);
        }

        String ans = "";
        int max = 0;

        int left = 0, right = 0;

        while (right < paragraph.length()) {
            if (!isAlphabet(paragraph.charAt(right))) {
                if (left != right) {
                    String word = paragraph.substring(left, right).toLowerCase();
                    if (!ban_set.contains(word)) {
                        int count = count_map.getOrDefault(word, 0) + 1;
                        count_map.put(word, count);
                        if (count > max) {
                            ans = word;
                            max = count;
                        }
                    }
                }
                left = right+1;
            }
            right++;
        }
        if (left != right) {
            String word = paragraph.substring(left, right).toLowerCase();
            if (!ban_set.contains(word)) {
                int count = count_map.getOrDefault(word, 0) + 1;
                count_map.put(word, count);
                if (count > max) {
                    ans = word;
                    max = count;
                }
            }
        }

        return ans;
    }

    private boolean isAlphabet(char c) {
        return (c - 'a' >= 0 && c - 'a' < 26) || (c - 'A' >= 0 && c -'A' < 26);
    }
}
