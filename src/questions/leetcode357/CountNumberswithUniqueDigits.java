package questions.leetcode357;

public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 0;

        if (n >= 10)
            n = 10;
        while (n > 0) {
            int temp = 9;
            for (int i=1; i<n; i++) {
                temp *= (10-i);
            }
            res += temp;
            n--;
        }
        return res+1;
    }
}
