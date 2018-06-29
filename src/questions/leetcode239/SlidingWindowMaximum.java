package questions.leetcode239;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k){
        // Empty input
        if (nums.length == 0) return new int[0];

        List<Integer> desc_list = new ArrayList<>();
        int[] res = new int[nums.length-k+1];


        int left =0, right = 0;
        while (right < k){
            addDesList(desc_list, nums[right]);
            right += 1;
        }

        res[left] = desc_list.get(0);

        while (right < nums.length){
            if (desc_list.get(0) == nums[left]){
                desc_list.remove(0);
            }
            addDesList(desc_list, nums[right]);

            left += 1;
            right += 1;
            res[left] = desc_list.get(0);
        }
        return res;
    }

    private void addDesList(List<Integer> list, int num){
        while (!list.isEmpty() && num > list.get(list.size()-1)) list.remove(list.size()-1);
        list.add(num);
    }
}
