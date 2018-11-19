package questions.leetcode801;

public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int n1 = 0, s1 = 1;
        for (int i=1; i<n; i++) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                n2 = Math.min(n2, n1);
                s2 = Math.min(s2, s1+1);
            }
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1+1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }
}
