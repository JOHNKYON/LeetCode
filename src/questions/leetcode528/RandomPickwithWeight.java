package questions.leetcode528;

import java.util.Random;

public class RandomPickwithWeight {
    Random random;
    int[] prefix;

    public RandomPickwithWeight(int[] w) {
        random = new Random();
        int sum = 0;
        prefix = new int[w.length];
        for (int i=0; i<w.length; i++) {
            sum += w[i];
            prefix[i] = sum;
        }
    }

    public int pickIndex() {
        int left = 0;
        int right = prefix.length-1;

        int r = random.nextInt(prefix[right]);

        while (left != right) {
            int mid = (left + right)/2;
            if (prefix[mid] > r)
                right = mid;
            else
                left = mid + 1;
        }
        return (left + right) / 2;
    }
}
