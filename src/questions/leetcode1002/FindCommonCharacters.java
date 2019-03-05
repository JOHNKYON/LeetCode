package questions.leetcode1002;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        if (A.length == 0)
            return ans;
        int[] count = new int[26];
        for (int i=0; i<26; i++)
            count[i] = Integer.MAX_VALUE;
        for (int i=0; i<A.length; i++) {
            int[] countThis = new int[26];
            for (char c: A[i].toCharArray()) {
                countThis[c-'a']++;
            }

            for (int j=0; j<26; j++) {
                count[j] = Math.min(count[j], countThis[j]);
            }
        }

        for (int i=0; i<26; i++) {
            while(count[i]-- != 0) {
                char c = (char)('a' + i);
                ans.add(String.valueOf(c));
            }
        }
        return ans;
    }
}
