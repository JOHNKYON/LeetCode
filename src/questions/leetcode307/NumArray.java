package questions.leetcode307;

public class NumArray {
    int[] nums;
    int[] sets;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.sets = new int[nums.length/10 + 1];
        for (int i=0; i<nums.length; i++) {
            this.nums[i] = nums[i];
            sets[i/10] += nums[i];
        }
    }

    public void update(int i, int val) {
        int diff = val - this.nums[i];
        this.nums[i] = val;
        this.sets[i/10] += diff;
    }

    public int sumRange(int i, int j) {
        int sum = 0;

        int start_set = i/10 ;
        int end_set = j/10;

        if (start_set == end_set) {
            for (int m=i; m <=j; m++)
                sum += this.nums[m];
        } else {
            for (int m=i; m<j && m < (start_set+1)*10; m++)
                sum += this.nums[m];
            for (int m=end_set*10; m <= j; m++)
                sum += this.nums[m];
            for (int m=start_set+1; m<end_set; m++)
                sum += this.sets[m];
        }

        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */