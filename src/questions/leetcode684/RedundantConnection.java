package questions.leetcode684;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];

        DSU dsu = new DSU(edges.length+1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1]))   return edge;
        }
        throw new AssertionError();
    }

    private class DSU {
        int[] parent;
        int[] rank;

        private DSU(int size) {
            parent = new int[size];
            for (int i=0; i<parent.length; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }

        private int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        private boolean union(int x, int y) {
            int xr = find(x);
            int yr = find(y);

            if (xr == yr) {
                return false;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else {
                parent[yr] = xr;
                rank[xr]++;
            }
            return true;
        }
    }
}
