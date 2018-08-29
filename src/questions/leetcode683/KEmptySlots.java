package questions.leetcode683;

import java.util.ArrayDeque;
import java.util.Deque;

public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        int len = flowers.length;
        int[] days = new int[len];

        for (int i=0; i<len; i++){
            days[flowers[i]-1] = i;
        }

        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = k+1;
        while (right < len){
            boolean valid = true;
            for (int i=left+1; i<right; i++){
                if (days[i] < days[left] || days[i] < days[right]){
                    left = i;
                    right = i + k + 1;
                    valid = false;
                    break;
                }
            }
            if (valid){
                res = Math.min(res, Math.max(days[left], days[right]));
                left = right;
                right = left + k + 1;
            }
        }

        return (res == Integer.MAX_VALUE)? -1: res+1;
    }
}
