package questions.leetcode304;

public class RangeSumQuery2DImmutable {
    int[][] sum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        sum = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                if (i != 0)
                    temp += sum[i-1][j];
                if (j != 0)
                    temp += sum[i][j-1];
                if (i != 0 && j != 0)
                    temp -= sum[i-1][j-1];
                sum[i][j] = temp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null || sum.length == 0 || sum[0].length == 0)
            return 0;

        int res = sum[row2][col2];

        if (row1 != 0)
            res -= sum[row1-1][col2];
        if (col1 != 0)
            res -= sum[row2][col1-1];
        if (row1 != 0 && col1 != 0)
            res += sum[row1-1][col1-1];

        return res;
    }
}
