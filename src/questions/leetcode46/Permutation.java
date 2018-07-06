package questions.leetcode46;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0)   return res;

        res.add(new ArrayList<Integer>());
        addList(0, nums, res, nums.length);
        return res;
    }

    private void addList(int cur, int nums[], List<List<Integer>> res, int length){
        if (cur == length)  return;
        else {
            int res_length = res.size();
            for (int j=0; j<res_length; j++){
                List<Integer> cur_list = res.get(j);
                List<Integer> temp = new ArrayList<>(cur_list);
                cur_list.add(0, nums[cur]);
                for (int i=1; i<=temp.size(); i++){
                    List<Integer> new_ans = new ArrayList<>(temp);
                    new_ans.add(i, nums[cur]);
                    res.add(new_ans);
                }
            }
            addList(cur+1, nums, res, length);
        }
        return;
    }
}
