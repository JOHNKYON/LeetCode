package questions.leetcode107;

import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            level.add(curr.val);
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
            size--;
            if (size == 0) {
                size = queue.size();
                ans.add(0, level);
                level = new ArrayList<>();
            }
        }
        return ans;
    }
}
