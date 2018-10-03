package questions.leetcode308;

public class RangeSumQuery2DMutable {
    int[][] matrix;
    int[][] col_sum;

    public RangeSumQuery2DMutable(int[][] m) {
        if (m.length <= 0)
            return;
        this.matrix = new int[m.length][m[0].length];
        this.col_sum = new int[m.length][m[0].length];
        for (int j=0; j<m[0].length; j++){
            this.matrix[0][j] = m[0][j];
            this.col_sum[0][j] = m[0][j];
        }

        for (int i=1; i<m.length; i++){
            for (int j=0; j<m[0].length; j++){
                this.matrix[i][j] = m[i][j];
                this.col_sum[i][j] = this.col_sum[i-1][j] + this.matrix[i][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        if (matrix == null)
            return;

        if (col < 0 && col >= matrix.length && val < 0 && val >= matrix[0].length)
            return;
        int diff = val - matrix[row][col];
        this.matrix[row][col] = val;
        for (int i=row; i<matrix.length; i++)
            this.col_sum[i][col] += diff;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.matrix == null)
            return 0;
        if (row1 < 0 && col1 < 0 && row2 >= this.matrix.length && col2 >= this.matrix[0].length)
            return 0;

        int sum = 0;
        for (int c = col1; c <= col2; c++)
            sum += this.col_sum[row2][c] - this.col_sum[row1][c] + this.matrix[row1][c];
        return sum;
    }
}
