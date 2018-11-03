package questions.leetcode276;

public class PaintFence {
    public int numWays(int n, int k) {
        int adj = 0;
        int nadj = 0;
        if (n <= 0 || (n > 2 && k < 2))
            return 0;
        if (n == 1)
            return k;

        adj = k;
        nadj = k * (k-1);

        for (int i=3; i<=n; i++) {
            int adj_temp = nadj;
            int nadj_temp = (adj + nadj) * (k-1);
            adj = adj_temp;
            nadj = nadj_temp;
        }
        return adj + nadj;
    }
}
