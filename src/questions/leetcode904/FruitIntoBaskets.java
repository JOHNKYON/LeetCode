package questions.leetcode904;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        if (tree == null)
            return 0;
        if (tree.length <= 2)
            return tree.length;

        int ans = 0;

        int left = 0;
        int bucket1 = tree[0], index1 = 0;
        int bucket2, index2 = 0;
        while (index2 < tree.length && tree[index2] == tree[0])
            index2++;

        if (index2 == tree.length)
            return tree.length;
        bucket2 = tree[index2];

        for (int i=0; i<tree.length; i++) {
            if (tree[i] == bucket1) {
                index1 = i;
            } else if (tree[i] == bucket2) {
                index2 = i;
            } else {
                ans = Math.max(i - left, ans);
                if (index1 > index2) {
                    left = index2 + 1;
                    bucket2 = tree[i];
                    index2 = i;
                } else {
                    left = index1 + 1;
                    bucket1 = tree[i];
                    index1 = i;
                }
            }
        }

        return Math.max(ans, tree.length-left);
    }
}
