package questions.leetcode96;

public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        if (n==0)   return 0;

        int[] subTree = new int[n+1];
        int count = 0;
        subTree[0] = 1;
        subTree[1] = 1;

        for(int i=2;i<=n;i++){
            for (int j=0; j<i;j++){
                subTree[i] += subTree[j] * subTree[i-1-j];
            }
        }
        return subTree[n];
    }
}
