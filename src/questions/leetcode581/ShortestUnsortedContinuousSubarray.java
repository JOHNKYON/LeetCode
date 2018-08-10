package questions.leetcode581;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int left = 0;
        int right = -1;

        boolean flag = false;

        for (int i=1; i<nums.length; i++){
            if (nums[i] < nums[i-1])
                flag = true;
            if (flag){
                min = Math.min(nums[i], min);
            }
        }
        flag = false;

        for (int i=nums.length-2; i>=0; i--){
            if (nums[i] > nums[i+1])
                flag = true;
            if (flag){
                max = Math.max(nums[i], max);
            }
        }

        for (int i=0; i<nums.length; i++){
            if (nums[i] > min){
                left = i;
                break;
            }
        }

        for (int i=nums.length-1; i>=0; i--){
            if (nums[i] < max){
                right = i;
                break;
            }
        }

        return right-left+1;
    }
}
