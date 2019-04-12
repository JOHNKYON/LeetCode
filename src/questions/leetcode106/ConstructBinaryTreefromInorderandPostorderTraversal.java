package questions.leetcode106;

import questions.dataStructure.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        for (int i: postorder)
            stack.push(i);
        return buildTree(inorder, stack, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, Stack<Integer> stack, int left, int right) {
        if (left > right)
            return null;
        int rootVal = stack.pop();
        int rootIdx = left;
        TreeNode root = new TreeNode(rootVal);
        while (rootIdx <= right && inorder[rootIdx] != rootVal) {
            rootIdx++;
        }
        root.right = buildTree(inorder, stack, rootIdx+1, right);
        root.left = buildTree(inorder, stack, left, rootIdx-1);
        return root;
    }
}
