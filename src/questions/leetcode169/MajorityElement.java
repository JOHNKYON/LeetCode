package questions.leetcode169;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;

        for (int i : nums){
            if (count == 0){
                majority = i;
            } if (majority == i){
                count++;
            } else count--;
        }

        return majority;
    }
}
