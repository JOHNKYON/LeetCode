package questions.leetcode78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backTrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start){
        res.add(new ArrayList<>(temp));
        for (int i = start; i<nums.length;i++){
            temp.add(nums[i]);
            backTrack(res, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
