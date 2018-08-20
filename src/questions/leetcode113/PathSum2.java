package questions.leetcode113;

import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();

        if (root == null)   return res;

        List<Integer> path = new ArrayList<>();

        buildPath(path, sum, 0, root);
        return res;
    }

    private void buildPath(List<Integer> path, int sum, int curr, TreeNode node){
        curr += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null){
            if (sum == curr)
                res.add(new ArrayList<>(path));
        }
        if (node.left != null){
            buildPath(path, sum, curr, node.left);
        }
        if (node.right != null){
            buildPath(path, sum, curr, node.right);
        }
        path.remove(path.size()-1);
        curr -= node.val;
        return;
    }
}
