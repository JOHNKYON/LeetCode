package questions.leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        build(nums, path, 0);
        return ans;
    }

    private void build(int[] nums, List<Integer> path, int start) {
        if (start <= nums.length) {
            ans.add(new ArrayList<>(path));
        }
        int i = start;
        while (i < nums.length) {
            path.add(nums[i]);
            build(nums, path, i+1);
            path.remove(path.size()-1);
            i++;
            while (i > start && i < nums.length && nums[i] == nums[i-1])
                i++;
        }
    }
}
