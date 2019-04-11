package questions.leetcode74;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int[] coo = idxToCoo(n, m, mid);
            if (matrix[coo[0]][coo[1]] >= target) {
                right = mid;
            } else
                left = mid + 1;
        }
        int[] coo = idxToCoo(n, m, left);
        return matrix[coo[0]][coo[1]] == target;
    }

    private int[] idxToCoo(int n, int m, int idx) {
        int[] coo = new int[2];
        coo[0] = idx / m;
        coo[1] = idx % m;
        return coo;
    }
}
