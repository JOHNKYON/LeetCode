package questions.leetcode637;

import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<TreeNode> node_list = new ArrayList<>();

        if (root == null)   return res;

        node_list.add(root);

        while(node_list.size() != 0){
            long  count = node_list.size();
            long  sum = 0;

            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : node_list){
                sum += node.val;
                if (node.left != null)  temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            res.add((sum * 1.0) / count);
            node_list = temp;
        }
        return res;
    }
}
