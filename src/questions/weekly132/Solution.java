package questions.weekly132;

import questions.dataStructure.TreeNode;

import java.util.Stack;

public class Solution {
    public TreeNode recoverFromPreorder(String s) {
        if (s.length() == 0)
            return null;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        int level = 0;
        int left = 0;
        int i=0;
        while (i<s.length()) {
            char c = s.charAt(i);
            if (c == '-') {
                level++;
                left = i+1;
            } else {
                while (i != s.length() && s.charAt(i) != '-') {
                    i++;
                }
                int val = Integer.parseInt(s.substring(left, i));
                TreeNode curr = new TreeNode(val);
                if (nodeStack.isEmpty()) {
                    nodeStack.push(curr);
                    levelStack.push(level);
                    level = 0;
                } else if (levelStack.peek() == level-1) {
                    TreeNode parent = nodeStack.peek();
                    if (parent.left == null) {
                        parent.left = curr;
                    } else {
                        parent.right = curr;
                    }
                    nodeStack.push(curr);
                    levelStack.push(level);
                    level = 0;
                } else {
                    while (levelStack.peek() != level-1) {
                        nodeStack.pop();
                        levelStack.pop();
                    }
                    TreeNode parent = nodeStack.peek();
                    if (parent.left == null) {
                        parent.left = curr;
                    } else {
                        parent.right = curr;
                    }
                    nodeStack.push(curr);
                    levelStack.push(level);
                    level = 0;
                }

                i--;
            }



            i++;
        }
        TreeNode root = null;
        while (!nodeStack.isEmpty())
            root = nodeStack.pop();
        return root;
    }
}
