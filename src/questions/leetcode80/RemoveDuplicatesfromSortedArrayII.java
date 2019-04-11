package questions.leetcode80;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int ptr = 2;
        for (int i=2; i<nums.length; i++) {
            if (nums[i] == nums[ptr-1] && nums[i] == nums[ptr-2])
                continue;
            swap(nums, ptr, i);
            ptr++;
        }
        return ptr;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
