package questions.leetcode947;

import java.util.HashSet;

public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20000);
        HashSet<Integer> seen = new HashSet<>();

        for (int[] stone: stones) {
            dsu.union(stone[0], stone[1] + 10000);
        }

        for (int[] stone: stones)
            seen.add(dsu.find(stone[0]));

        return stones.length - seen.size();
    }

    private class DSU{
        int[] parent;

        public DSU(int n) {
            parent = new int[n];

            for (int i=0; i<n; i++)
                parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int i, int j) {
            parent[find(i)] = find(j);
        }
    }
}
