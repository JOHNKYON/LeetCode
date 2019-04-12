package questions.leetcode39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        searchSum(candidates, res, new ArrayList<>(), target, 0);


        return res;
    }

    private void searchSum(int[] nums, List<List<Integer>> res, List<Integer> temp_list, int target, int begin){
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<>(temp_list));
            return;
        }
        else {
            for (int i = begin; i<nums.length; i++){
                temp_list.add(nums[i]);
                searchSum(nums, res, temp_list, target-nums[i], i);
                temp_list.remove(temp_list.size()-1);
            }
        }
    }
}
