package questions.leetcode498;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int[] ans = new int[matrix.length*matrix[0].length];
        int curr = 0;
        int i=0, j=0;
        while (curr < matrix.length * matrix[0].length) {
            if (((i+j) & 1) == 0) {
                while (i >= matrix.length || j < 0) {
                    i--; j++;
                }
                while (i >= 0 && j < matrix[0].length) {
                    ans[curr++] = matrix[i--][j++];
                }
                i++;
            } else {
                while (i < 0 || j >= matrix[0].length) {
                    i++; j--;
                }
                while (i < matrix.length && j >= 0)
                    ans[curr++] = matrix[i++][j--];
                i++;
            }
        }
        return ans;
    }
}
