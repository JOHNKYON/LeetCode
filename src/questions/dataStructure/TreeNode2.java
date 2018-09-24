package questions.dataStructure;

import java.util.List;

public class TreeNode2 {
    public int val;
    public List<TreeNode2> children;

    public TreeNode2() {}

    public TreeNode2(int _val,List<TreeNode2> _children) {
        val = _val;
        children = _children;
    }
}
