package questions.leetcode547;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0)
            return 0;

        int n = M.length;
        DSU dsu = new DSU(n);

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (M[i][j] == 1)
                    dsu.union(i, j);
            }
        }
        return dsu.unique();
    }

    private class DSU {
        int[] parents;

        public DSU(int n) {
            parents = new int[n];
            for (int i=0; i<n; i++) {
                parents[i] = i;
            }
        }

        private int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        private void union(int a, int b) {
            int ap = find(a);
            int bp = find(b);
            if (ap != bp) {
                parents[ap] = bp;
            }
        }

        private int unique() {
            int count = 0;
            for (int i=0; i<parents.length; i++) {
                if (parents[i] == i)
                    count++;
            }
            return count;
        }
    }
}
