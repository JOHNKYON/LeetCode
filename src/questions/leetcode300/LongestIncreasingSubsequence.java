package questions.leetcode300;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)   return 0;

        List<Integer> columns = new ArrayList<>();
        for (int i : nums){
            if (columns.size()==0 || i > columns.get(columns.size()-1)){
                columns.add(i);
                continue;
            }

            int pos = findPosition(columns, i, 0, columns.size()-1);
            columns.set(pos, i);
        }

        return columns.size();
    }

    private int findPosition(List<Integer> columns, int i, int left, int right){
        int mid = (left+right)/2;
        if ( i<=columns.get(mid) && (mid == 0 || i > columns.get(mid-1)))
            return mid;
        else {
            if (i > columns.get(mid))
                return findPosition(columns, i, mid+1, right);
            else
                return findPosition(columns, i, left, mid-1);
        }
    }
}
