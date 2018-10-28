package questions.leetcode932;

public class BeautifulArray {
    public int[] beautifulArray(int n) {
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
            return res;
        }
        else {
            int[] left = beautifulArray(n/2);
            int[] right = beautifulArray(n - n/2);
            for (int i=0; i<n/2; i++) {
                res[i] = left[i]*2;
            }
            for (int i=0; i<n - n/2; i++) {
                res[i + n/2] = right[i] * 2 - 1;
            }
        }

        return res;
    }
}
