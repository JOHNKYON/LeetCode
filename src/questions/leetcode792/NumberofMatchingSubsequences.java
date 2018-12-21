package questions.leetcode792;

import java.util.Arrays;

public class NumberofMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        // Save the index of the next character for the String s. Construct the indexes by going backwards the s. Update the ptr of each character.
        // When reached -1, false;
        int[][] next = new int[S.length()+1][26];
        int[] curr = new int[26];
        Arrays.fill(curr, -1);
        for (int i=S.length()-1; i>=0; i--) {
            for (int j=0; j<26; j++) {
                next[i+1][j] = curr[j];
            }
            curr[S.charAt(i)-'a'] = i+1;
        }
        for (int j=0; j<26; j++)
            next[0][j] = curr[j];
        int count = 0;
        for (String word: words) {
            if (word.length() > S.length())
                continue;
            int ptr=0;
            int i=0;
            for (i=0; i<word.length(); i++) {
                if (next[ptr][word.charAt(i)-'a'] == -1)
                    break;
                else
                    ptr = next[ptr][word.charAt(i)-'a'];
            }
            if (i == word.length())
                count++;
        }
        return count;
    }
}
