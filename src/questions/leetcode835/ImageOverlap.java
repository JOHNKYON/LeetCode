package questions.leetcode835;

public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int m = 0;
        if (n != 0)
            m = A[0].length;

        int max = 0;

        for (int v=0; v<n; v++) {
            for (int h=0; h<m; h++) {
                max = Math.max(max, count(A, B, v, h));
            }
        }
        return max;
    }

    private int count(int[][] A, int[][] B, int v, int h) {
        int max = 0;
        for (int i=0; i+v<A.length; i++) {
            for (int j=0; j+h<A[0].length; j++)
                max += (A[i+v][j+h] == 1 && B[i][j] == 1)? 1: 0;
        }
        int max2 = 0;
        for (int i=0; i+v<A.length; i++) {
            for (int j=0; j+h<A[0].length; j++)
                max2 += (A[i][j] == 1 && B[i+v][j+h] == 1)? 1: 0;
        }

        return Math.max(max, max2);
    }
}
