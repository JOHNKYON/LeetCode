package questions.leetcode845;

public class LongestMountaininArrayLongestMountaininArray {
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        int ans = 0;
        int ptr1 = -1;
        int peak = -1;
        for (int i=1; i<A.length; i++) {
            if (ptr1 == -1 && A[i] > A[i-1])
                ptr1 = i-1;
            if (ptr1 != -1 && peak == -1 && A[i] < A[i-1])
                peak = i-1;
            if (peak == -1 && A[i] == A[i-1])
                ptr1 = -1;
            if (peak != -1 && A[i] >= A[i-1]) {
                if (peak != 0)
                    ans = Math.max(i - ptr1, ans);
                if (A[i] > A[i-1])
                    ptr1 = i-1;
                else
                    ptr1 = -1;
                peak = -1;
            }
        }
        if (peak != -1 && peak != 0 && ptr1 != -1)
            ans = Math.max(A.length - ptr1, ans);

        return ans >= 3? ans: 0;
    }
}
