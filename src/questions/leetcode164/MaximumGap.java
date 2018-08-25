package questions.leetcode164;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length<2)  return 0;

        int res = 0;

        int max=nums[0];
        int min=nums[0];

        for(int i:nums){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int gap = (max - min) / (nums.length-1);

        gap = (gap == 0)?   1: gap;

        int len = (max-min) / gap + 1;

        int[] bucket_max = new int[len];
        int[] bucket_min = new int[len];

        for (int n: nums){
            int bucket_index = (n - min) / gap;
            bucket_max[bucket_index] = Math.max(bucket_max[bucket_index], n);
            if (bucket_min[bucket_index] == 0 || n < bucket_min[bucket_index])
                bucket_min[bucket_index] = n;
        }

        for(int i = 0;i < len;i++){
            if(res < bucket_min[i]-min) res = bucket_min[i]- min;
            if(bucket_max[i] != 0) min = bucket_max[i];
        }

        return res;
    }
}
