package questions.leetcode427;

import questions.dataStructure.Node;

public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        int len = grid.length;

        return buildTree(grid, 0, len-1, 0, len-1);
    }

    private Node buildTree(int[][] grid, int i1, int i2, int j1, int j2){
        if (i1 > i2 || j1 > j2) return null;

        int mid1 = (i1+i2)/2;
        int mid2 = (j1+j2)/2;

        for (int i=i1; i<=i2; i++){
            for (int j=j1; j<=j2; j++){
                if (grid[i][j] != grid[i1][j1]){
                    return new Node(true, false,
                            buildTree(grid, i1, mid1, j1, mid2),
                            buildTree(grid, i1, mid1, mid2+1, j2),
                            buildTree(grid, mid1+1, i2, j1, mid2),
                            buildTree(grid, mid1+1, i2, mid2+1, j2));
                }
            }
        }

        return new Node(grid[i1][j1]==1, true, null, null, null, null);
    }
}
