package questions.leetcode413;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int n = A.length;
        int left = 0;

        if (A == null || n == 0 || n == 1 || n == 2)
            return 0;

        for (int i=2; i<n; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]){
                if (left == Integer.MAX_VALUE)
                    left = i-2;
            } else {
                int len = i - left;
                if (len >= 3) {
                    int temp = (len - 3 + 1 + 1) * (len - 3 + 1) / 2;
                    res += temp;
                }
                left = Integer.MAX_VALUE;
            }
        }
        if (left < n-2) {
            int len = n - left;
            if (len >= 3) {
                int temp = (len - 3 + 1 + 1) * (len - 3 + 1) / 2;
                res += temp;
            }
        }

        return res;
    }
}
