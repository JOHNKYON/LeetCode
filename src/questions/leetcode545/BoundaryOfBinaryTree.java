package questions.leetcode545;

import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BoundaryOfBinaryTree {
    List<Integer> ans;
    HashSet<TreeNode> seen;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ans = new ArrayList<>();
        seen = new HashSet<>();
        if (root == null)
            return ans;

        if (root.left != null)
            searchLeft(root);
        else {
            seen.add(root);
            ans.add(root.val);
        }
        searchLeaf(root);
        if (root.right != null)
            searchRight(root);

        return ans;
    }

    private void searchLeft(TreeNode root) {
        if (root == null)
            return;
        if (!seen.contains(root)){
            seen.add(root);
            ans.add(root.val);
        }
        if (root.left != null)
            searchLeft(root.left);
        else
            searchLeft(root.right);
    }

    private void searchLeaf(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && !seen.contains(root)) {
            seen.add(root);
            ans.add(root.val);
        }
        searchLeaf(root.left);
        searchLeaf(root.right);
    }

    private void searchRight(TreeNode root) {
        if (root == null)
            return;
        if (root.right != null)
            searchRight(root.right);
        else
            searchRight(root.left);
        if (!seen.contains(root)) {
            seen.add(root);
            ans.add(root.val);
        }
    }
}
