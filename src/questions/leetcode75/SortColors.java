package questions.leetcode75;

public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;

        for (int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                swap(nums, p0+p1, i);
                p1++;
            } else if(nums[i] == 0){
                swap(nums, p0+p1, i);
                swap(nums, p0+p1, p0);
                p0++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}
