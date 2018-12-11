package questions.dataStructure;

public class TreeNode3 {
    public boolean val;
    public boolean isLeaf;
    public TreeNode3 topLeft;
    public TreeNode3 topRight;
    public TreeNode3 bottomLeft;
    public TreeNode3 bottomRight;

    public TreeNode3() {}

    public TreeNode3(boolean _val, boolean _isLeaf, TreeNode3 _topLeft, TreeNode3 _topRight, TreeNode3 _bottomLeft, TreeNode3 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
