package questions.leetcode428;

import questions.dataStructure.TreeNode2;

import java.util.ArrayList;
import java.util.Stack;

public class SerializeandDeserializeNaryTree {
    public String serialize(TreeNode2 root) {
        StringBuilder sb = new StringBuilder();

        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode2 node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val);
            sb.append('[');
            for (TreeNode2 n : node.children) {
                buildString(n, sb);
            }
            sb.append(']');
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode2 deserialize(String data) {
        int i=0, len=data.length();
        TreeNode2 root=null;
        Stack<TreeNode2> stack = new Stack<>();
        while(i<len){
            int start=i;
            while(i<len && Character.isDigit(data.charAt(i))) i++;
            if(start==i){
                TreeNode2 child = stack.pop();
                if(stack.isEmpty()) {root=child; break;}
                stack.peek().children.add(child);
            }else {
                stack.push(new TreeNode2(Integer.parseInt(data.substring(start,i)),new ArrayList<TreeNode2>()));
            }
            i++;
        }
        return root;
    }
}
