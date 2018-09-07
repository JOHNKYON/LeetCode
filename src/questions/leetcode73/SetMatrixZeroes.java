package questions.leetcode73;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int flag = Integer.MIN_VALUE + 1;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0) {
                    for (int col=0; col<matrix[0].length; col++){
                        if (matrix[i][col] != 0)
                            matrix[i][col] = flag;
                    }
                    for (int row=0; row<matrix.length; row++)
                        if (matrix[row][j] != 0)
                            matrix[row][j] = flag;
                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == flag)
                    matrix[i][j] = 0;
            }
        }
    }
}
