package questions.leetcode261;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int count = 0;
        for (int[] edge: edges) {
            if (dsu.find(edge[0]) == dsu.find(edge[1]))
                return false;
            dsu.merge(edge[0], edge[1]);
        }
        for (int i=0; i<n; i++) {
            if (dsu.parent[i] == i)
                count++;
            if (count > 1)
                return false;
        }
        return edges.length == n-1;
    }

    private class DSU {
        int[] parent;
        private DSU(int n) {
            parent = new int[n];
            for (int i=0; i<n; i++)
                parent[i] = i;
        }

        private int find(int a) {
            if (parent[a] != a)
                parent[a] = find(parent[a]);
            return parent[a];
        }

        private void merge(int a, int b) {
            int ap = find(a);
            int bp = find(b);
            if (ap != bp) {
                parent[ap] = bp;
            }
        }
    }
}
