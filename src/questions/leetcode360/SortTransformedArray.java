package questions.leetcode360;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];

        if (a == 0) {
            for (int i=0; i<nums.length; i++) {
                if (b < 0) {
                    res[i] = f(nums[nums.length-1-i], a, b, c);
                } else
                    res[i] = f(nums[i], a, b, c);
            }
            return res;
        }


        double threshold = - (double)(b) / ((double)(a) * 2.0);
        int minus = 0;
        int plus = nums.length-1;
        int curr = res.length-1;
        while (minus <= plus) {
            if (nums[minus] < threshold && nums[plus] > threshold) {
                if (threshold - nums[minus] > nums[plus] - threshold) {
                    res[curr] = f(nums[minus], a, b, c);
                    curr--;
                    minus++;
                } else {
                    res[curr] = f(nums[plus], a, b, c);
                    curr--;
                    plus--;
                }
            } else if (nums[minus] >= threshold) {
                res[curr] = f(nums[plus], a, b, c);
                curr--;
                plus--;
            } else if (nums[plus] <= threshold) {
                res[curr] = f(nums[minus], a, b, c);
                curr--;
                minus++;
            }
        }
        if (a < 0) {
            for (int i=0; i<res.length/2; i++) {
                int temp = res[i];
                res[i] = res[res.length-1-i];
                res[res.length-1-i] = temp;
            }
        }

        return res;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
