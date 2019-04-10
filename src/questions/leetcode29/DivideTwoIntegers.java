package questions.leetcode29;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend ^ divisor) < 0)
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        long lans = ldivide(ldividend, ldivisor);

        int ans = 0;
        if (lans > Integer.MAX_VALUE) {
            return (sign == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE;
        } else
            return sign * Math.toIntExact(lans);
    }

    private long ldivide(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        long sum = divisor;
        long count = 1;
        while ((sum + sum) < dividend) {
            sum += sum;
            count += count;
        }
        return count + ldivide(dividend - sum, divisor);
    }
}
