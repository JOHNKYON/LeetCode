package questions.leetcode324;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int lo = nums.length / 2 - 1;
        if (nums.length % 2 != 0) lo++;
        int high = nums.length - 1;
        int[] newNums = nums.clone();
        for (int i = 0; i < newNums.length; i += 2) {
            nums[i] = newNums[lo];
            lo--;
        }
        for (int i = 1; i < newNums.length; i+= 2) {
            nums[i] = newNums[high];
            high--;
        }
    }
}
