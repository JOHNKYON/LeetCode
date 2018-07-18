package questions.leetcode102;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> node_list = new ArrayList<>();

        if(root==null)  return res;

        node_list.add(root);
        List<Integer> level = new ArrayList<>();

        int level_count = 1;

        while(!node_list.isEmpty()){
            if (level_count == 0)   {
                level_count = node_list.size();
                res.add(level);
                level = new ArrayList<>();
            }
            TreeNode curr = node_list.get(0);
            node_list.remove(0);
            if (curr.left != null)  node_list.add(curr.left);
            if (curr.right != null) node_list.add(curr.right);

            level.add(curr.val);
            level_count--;
        }

        res.add(level);

        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
