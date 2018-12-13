package questions.leetcode266;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        return set.size() <= 1;
    }

    public boolean canPermutePalindrome2(String s) {
        char [] map = new char[130];
        int odd = 0;
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if ((map[s.charAt(i)] & 1) == 0)
                odd--;
            else
                odd++;
        }


        return odd <= 1;
    }
}
