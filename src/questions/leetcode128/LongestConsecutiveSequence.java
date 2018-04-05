package questions.leetcode128;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int longest = 0, length = 0, current = 0;
        for (int num : set){
            if (!set.contains(num-1)){
                length = 1;
                current = num;
            }
            while (set.contains(current+1)){
                current += 1;
                length += 1;
            }

            longest = (longest > length)? longest : length;
        }
        return longest;
    }
}
