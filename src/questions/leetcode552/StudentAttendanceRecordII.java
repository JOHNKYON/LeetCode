package questions.leetcode552;

public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        if (n < 1)
            return 0;
        long div = 1000000007;
        long p = 1;
        long a1 = 1;
        long a1l1 = 0;
        long a1l2 = 0;
        long l1 = 1;
        long l2 = 0;
        for (int i=1; i<n; i++) {
            long p_t = (p + l1 + l2) % div;
            long a1_t = (a1 + p + a1l1 + a1l2 + l1 + l2) % div;
            long a1l1_t = a1 % div;
            long a1l2_t = a1l1 % div;
            long l1_t = p % div;
            long l2_t = l1 % div;
            p = p_t;
            a1 = a1_t;
            a1l1 = a1l1_t;
            a1l2 = a1l2_t;
            l1 = l1_t;
            l2 = l2_t;
        }
        long ans = p;
        ans = (ans + a1) % div;
        ans = (ans + a1l1) % div;
        ans = (ans + a1l2) % div;
        ans = (ans + l1) % div;
        ans = (ans + l2) % div;
        return (int)ans;
    }
}
