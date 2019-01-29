package questions.leetcode449;

import questions.dataStructure.TreeNode;

import java.util.Arrays;

public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(sb, root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        int[] pres = toIntArray(data);
        int[] ins = new int[pres.length];
        for (int i=0; i<pres.length; i++)
            ins[i] = pres[i];

        Arrays.sort(ins);
        return buildTree(pres, ins, 0, 0, ins.length-1);
    }

    private TreeNode buildTree(int[] pre, int[] in,int pre_s, int in_s, int in_e) {
        if (pre_s >= pre.length || in_s > in_e)
            return null;

        TreeNode root = new TreeNode(pre[pre_s]);
        int index = in_s;
        for (; index < in_e; index++) {
            if (in[index] == root.val)
                break;
        }

        root.left = buildTree(pre, in, pre_s + 1, in_s, index-1);
        root.right = buildTree(pre, in, pre_s + index - in_s + 1, index+1, in_e);
        return root;
    }

    private void preOrder(StringBuilder sb, TreeNode root) {
        if (root != null) {
            sb.append(root.val);
            sb.append(' ');
            preOrder(sb, root.left);
            sb.append(' ');
            preOrder(sb, root.right);
            sb.append(' ');
        }
    }

    private int[] toIntArray(String str) {
        String[] subs = str.split(" +");
        int[] pre = new int[subs.length];
        for (int i=0; i<subs.length; i++) {
            pre[i] = Integer.parseInt(subs[i]);
        }
        return pre;
    }
}
