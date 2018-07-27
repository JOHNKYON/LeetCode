package questions.leetcode221;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = (matrix.length>0)? matrix[0].length : 0;

        int[] record = new int[m+1];
        int max = 0;
        int prev = 0;

        for(int i=0; i<n; i++){
            for(int j=1; j<=m; j++){
                int temp = record[j];
                if (matrix[i][j-1] == '1'){
                    record[j] = Math.min(Math.min(record[j-1], record[j]), prev)+1;
                    max = Math.max(max, record[j]);
                }
                else{
                    record[j] = 0;
                }
                prev = temp;
            }
        }

        return max*max;
    }
}
