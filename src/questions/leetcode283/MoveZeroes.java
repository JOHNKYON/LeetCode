package questions.leetcode283;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0)   return;

        int left = 0;
        while(left < nums.length && nums[left] != 0)  left++;

        for (int i=left+1; i<nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = 0;
                nums[left] = temp;
                left++;
            }
        }
    }
}
