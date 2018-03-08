package questions.longestSubstringWithoutRep;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JOHNKYON on 2018/3/8.
 * This is a solution to LeetCode Questions.
 */
public class LongestSubStringWithoutRep {
    public Integer longest(String s){
        int begin = 0, end = 0, left = 0, right = 0;
        int maxLen = 0;
        int len = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        while (right < s.length()){
            if (!hashMap.containsKey(s.charAt(right))){       //The new char hasn't shown before.
                hashMap.put(s.charAt(right), right);          //Add the new char to hashmap
                len += 1;                                       //Length += 1
                right += 1;                                     //Right pointer moves on step
            } else {
                if (len > maxLen) {begin = left; end = right; maxLen = len;}
                left = Math.max(hashMap.get(s.charAt(right))+1, left);
                len = right - left + 1;                                        //Calculate the latest length
                hashMap.put(s.charAt(right), right);
                right += 1;
            }
        }
        if (len > maxLen) {begin = left; end = right; maxLen = len;}
        return maxLen;
    }
}
