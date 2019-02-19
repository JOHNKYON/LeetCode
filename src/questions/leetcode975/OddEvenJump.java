package questions.leetcode975;

public class OddEvenJump {
    int[] odds;
    int[] evens;
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        if (n == 0)
            return 0;
        odds = new int[n];
        evens = new int[n];
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (search(A, i, true) == 1) {
                ans++;
            }
        }
        return ans;
    }

    private int search(int[] A, int i, boolean odd) {
        if (i == A.length-1) {
            return 1;
        }
        if (odd) {
            if (odds[i] != 0)
                return odds[i];
            int next = -1;
            int val = Integer.MAX_VALUE;
            for (int j=i+1; j<A.length; j++) {
                if (A[i] <= A[j] && (next == -1 || val > A[j])) {
                    next = j;
                    val = A[j];
                }
            }
            if (next == -1) {
                odds[i] = -1;
            } else {
                odds[i] = search(A, next, false);
            }
            return odds[i];
        } else {
            if (evens[i] != 0)
                return evens[i];
            int next = -1;
            int val = Integer.MIN_VALUE;
            for (int j=i+1; j<A.length; j++) {
                if (A[i] >= A[j] && (next == -1 || val < A[j])) {
                    next = j;
                    val = A[j];
                }
            }if (next == -1) {
                evens[i] = -1;
            } else {
                evens[i] = search(A, next, true);
            }
            return evens[i];
        }
    }
}
