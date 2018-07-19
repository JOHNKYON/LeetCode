package questions.leetcode105;

import questions.dataStructure.TreeNode;

import java.util.HashMap;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end){
        if (pre_end < pre_start || in_end < in_start)   return null;

        TreeNode root = new TreeNode(preorder[pre_start]);
        int in_root = map.get(root.val);
        int left_count = in_root-in_start;

        root.left = build(preorder, pre_start+1, pre_start+left_count, inorder, in_start, in_root-1);
        root.right = build(preorder, pre_start+left_count+1, pre_end, inorder, in_root+1, in_end);
        return root;
    }
}
