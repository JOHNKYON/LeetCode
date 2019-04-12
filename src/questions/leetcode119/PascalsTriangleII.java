package questions.leetcode119;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int[] a = new int[rowIndex+1];
        for (int i=0; i<=rowIndex; i++) {
            int[] next = new int[rowIndex+1];
            next[0] = 1;
            for (int j=1; j<i; j++) {
                next[j] = a[j-1] + a[j];
            }
            next[i] = 1;
            a = next;
        }
        for (int num: a)
            ans.add(num);
        return ans;
    }
}
