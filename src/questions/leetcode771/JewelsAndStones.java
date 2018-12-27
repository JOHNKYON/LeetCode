package questions.leetcode771;

import java.util.HashSet;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        for (char c: J.toCharArray())
            set.add(c);
        for (char c: S.toCharArray())
            ans += set.contains(c)? 1:0;
        return ans;
    }


    public int numJewelsInStones2(String J, String S) {
        // This one is faster
        int ans = 0;
        for (char c: S.toCharArray())
            ans += J.indexOf(c) >= 0? 1:0;
        return ans;
    }


}
