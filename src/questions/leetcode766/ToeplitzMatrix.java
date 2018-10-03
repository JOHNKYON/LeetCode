package questions.leetcode766;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return false;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i=0; i<col; i++) {
            int r = 0;
            int c = i;
            while (r < row && c < col) {
                if (matrix[r][c] != matrix[0][i])
                    return false;
                r++;
                c++;
            }
        }
        for (int i=1; i<row; i++) {
            int r=i;
            int c=0;
            while (r<row && c<col) {
                if (matrix[r][c] != matrix[i][0])
                    return false;
                r++;
                c++;
            }
        }

        return true;
    }
}
