package questions.leetcode698;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    private boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }


    // TODO: Understanding these algorithms

    enum Result { TRUE, FALSE }

    private boolean search(int used, int todo, Result[] memo, int[] nums, int target) {
        if (memo[used] == null) {
            memo[used] = Result.FALSE;
            int targ = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if ((((used >> i) & 1) == 0) && nums[i] <= targ) {
                    if (search(used | (1<<i), todo - nums[i], memo, nums, target)) {
                        memo[used] = Result.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Result.TRUE;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;

        Result[] memo = new Result[1 << nums.length];
        memo[(1 << nums.length) - 1] = Result.TRUE;
        return search(0, sum, memo, nums, sum / k);
    }

    public boolean canPartitionKSubsets3(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        int target = sum / k;
        return dfs(nums,visited,k,0,0,0,target);
    }
    private boolean dfs(int[] nums,boolean[] visited, int k, int subsum,int index, int count,int target){
        //1.base case
        if(subsum == target){
            k--;
            if(k == 0 && count == nums.length){
                return true;
            }else{
                return dfs(nums,visited,k,0,0,count,target);
            }
        }
        //2.general case
        for(int i = index; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(nums[i] + subsum > target){
                continue;
            }
            visited[i] = true;
            if(dfs(nums,visited,k,subsum + nums[i], i + 1,count + 1, target)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
