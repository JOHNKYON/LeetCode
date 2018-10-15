package questions.leetcode95;

import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
    List<TreeNode> res;
    public List<TreeNode> generateTrees(int n) {
        res = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            List<TreeNode> left = generate(1, i-1);
            List<TreeNode> right = generate(i+1, n);
            insert(i, left, right, res);
        }
        return res;
    }

    private void insert(int i, List<TreeNode> left, List<TreeNode> right, List<TreeNode> res) {
        for (int l=0; l<left.size(); l++) {
            for (int r=0; r<right.size(); r++) {
                TreeNode root = new TreeNode(i);
                root.left = left.get(l);
                root.right = right.get(r);
                res.add(root);
            }
        }
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end)
            trees.add(null);

        for (int i=start; i<=end; i++) {
            List<TreeNode> left = generate(start, i-1);
            List<TreeNode> right = generate(i+1, end);
            insert(i, left, right, trees);
        }

        return trees;
    }

}
