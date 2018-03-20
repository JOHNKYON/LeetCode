/**
 * Created by JOHNKYON on 2018/3/7.
 * This is a solution to LeetCode Questions.
 */

package questions.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap= new HashMap<>();
        for (int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if (myMap.containsKey(complement)){
                return new int[] {myMap.get(complement), i};
            }
            myMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
