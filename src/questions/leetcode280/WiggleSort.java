package questions.leetcode280;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        boolean les = true;
        for (int i=0; i<nums.length-1; i++){
            if (les){
                if (nums[i] >= nums[i+1]){
                    swap(nums, i, i+1);
                }
            } else {
                if (nums[i] <= nums[i+1]){
                    swap(nums, i, i+1);
                }
            }
            les = !les;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
