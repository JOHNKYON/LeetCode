package questions.leetcode103;

import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;

        List<TreeNode> candis = new ArrayList<>();
        candis.add(root);
        boolean left = true;
        while (!candis.isEmpty()) {
            List<TreeNode> next_level = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<candis.size(); i++) {
                TreeNode candi = candis.get(i);
                if (candi.left != null)
                    next_level.add(candi.left);
                if (candi.right != null)
                    next_level.add(candi.right);

                if (left)
                    level.add(candi.val);
                else
                    level.add(0, candi.val);
            }
            ret.add(level);
            candis = next_level;

            left = !left;
        }
        return ret;
    }
}
