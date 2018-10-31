package questions.leetcode694;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    int[][] grid;
    boolean[][] seen;
    Set<Integer> shape;

    public void explore(int r, int c, int r0, int c0) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {
            seen[r][c] = true;
            shape.add((r - r0) * 2 * grid[0].length + (c - c0));
            explore(r+1, c, r0, c0);
            explore(r-1, c, r0, c0);
            explore(r, c+1, r0, c0);
            explore(r, c-1, r0, c0);
        }
    }
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<HashSet<Integer>>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new HashSet<Integer>();
                explore(r, c, r, c);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }

    ArrayList<Integer> shape2;

    public void explore2(int r, int c, int di) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {
            seen[r][c] = true;
            shape.add(di);
            explore2(r+1, c, 1);
            explore2(r-1, c, 2);
            explore2(r, c+1, 3);
            explore2(r, c-1, 4);
            shape.add(0);
        }
    }
    public int numDistinctIslands2(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<ArrayList<Integer>>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape2 = new ArrayList<Integer>();
                explore2(r, c, 0);
                if (!shape2.isEmpty()) {
                    shapes.add(shape2);
                }
            }
        }

        return shapes.size();
    }
}
