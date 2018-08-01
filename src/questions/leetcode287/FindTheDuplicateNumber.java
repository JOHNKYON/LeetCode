package questions.leetcode287;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int left = 0;
        while(nums[left] != nums[fast]){
            left = nums[left];
            fast = nums[fast];
        }
        return nums[left];
    }
}
