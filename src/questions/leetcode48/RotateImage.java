package questions.leetcode48;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n==0) return;


        for(int i = 0; i < n-1; i++){
            for (int j = i; j<n-i-1; j++){
                swap(matrix, i, j, j, n-1-i);
                swap(matrix, i, j, n-1-i, n-1-j);
                swap(matrix, i, j, n-1-j, i);
            }
        }

        return;
    }

    private void swap(int[][] matrix, int a1, int a2, int b1, int b2){
        int temp = matrix[a1][a2];
        matrix[a1][a2] = matrix[b1][b2];
        matrix[b1][b2] = temp;
    }
}
