package questions.leetcode675;

import java.util.*;

public class CutOffTreesforGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for (int r=0; r<forest.size(); r++) {
            for (int c=0; c<forest.get(0).size(); c++) {
                int v = forest.get(r).get(c);
                if (v > 1)
                    trees.add(new int[]{v,r,c});
            }
        }

        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int ans = 0, r0 = 0, c0 = 0;
        for (int[] tree: trees) {
            int d = dist(forest, r0, c0, tree[1], tree[2]);
            if (d < 0)
                return -1;
            ans += d;
            r0 = tree[1];
            c0 = tree[2];
        }

        return ans;
    }

    private int dist(List<List<Integer>> forest, int r0, int c0, int r1, int c1) {
        int[][] moves = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int r = forest.size(), c = forest.get(0).size();

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{r0, c0, 0});
        boolean[][] seen = new boolean[r][c];
        seen[r0][c0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == r1 && curr[1] == c1)
                return curr[2];
            for (int[] move: moves) {
                int nr = curr[0] + move[0];
                int nc = curr[1] + move[1];
                if (nr >= 0 && nr < r && nc >= 0 && nc < c && !seen[nr][nc] && forest.get(nr).get(nc) > 0) {
                    seen[nr][nc] = true;
                    queue.add(new int[]{nr, nc, curr[2] + 1});
                }
            }
        }
        return -1;
    }

}
