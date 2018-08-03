package questions.leetcode315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        if (n == 0) return res;

        TreeNode root = new TreeNode(nums[n-1]);
        res.add(0);

        for(int i=n-2; i>=0; i--){
            TreeNode node = root;
            int count = 0;
            while (true){
                if (nums[i] <= node.val){
                    node.count++;
                    if (node.left == null){
                        node.left = new TreeNode(nums[i]);
                        break;
                    } else{
                        node = node.left;
                    }
                } else {
                    count += node.count;
                    if (node.right == null){
                        node.right = new TreeNode(nums[i]);
                        break;
                    } else{
                        node = node.right;
                    }
                }
            }
            res.add(count);
        }

        Collections.reverse(res);
        return res;
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        int count;

        public TreeNode(int x){
            this.val = x;
            this.count = 1;
        }
    }
}
