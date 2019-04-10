package questions.leetcode27;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int ptr = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, ptr, i);
                ptr++;
            }
        }
        return ptr;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
