package questions.leetcode13;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        int stage = 0;
        int ans = 0;
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('I', new int[]{0, 1});
        map.put('V', new int[]{1, 5});
        map.put('X', new int[]{1, 10});
        map.put('L', new int[]{2, 50});
        map.put('C', new int[]{2, 100});
        map.put('D', new int[]{3, 500});
        map.put('M', new int[]{3, 1000});
        for (int i=s.length()-1; i>=0; i--) {
            int[] symbo = map.get(s.charAt(i));
            if (stage > symbo[0]) {
                ans -= symbo[1];
            } else {
                ans += symbo[1];
                stage = symbo[0];
            }
        }

        return ans;
    }
}
