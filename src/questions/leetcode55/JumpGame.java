package questions.leetcode55;

public class JumpGame {
    public boolean canJump(int[] nums) {
        return reach(nums, nums.length-1);
    }

    private boolean reach(int[] nums, int curr){
        if(curr == 0) return true;

        int left = curr-1;
        while (left >= 0){
            if (curr-left <= nums[left]){
                if(left == 0) return true;
                return reach(nums, left);
            }
            left--;
        }
        return false;
    }
}
