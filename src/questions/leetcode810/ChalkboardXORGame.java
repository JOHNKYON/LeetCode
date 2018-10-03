package questions.leetcode810;

public class ChalkboardXORGame {
    public boolean xorGame(int[] nums) {
        int len = nums.length;

        int x = 0;
        for (int n : nums)
            x = x ^ n;

        return x == 0 || len % 2 == 0;
    }
}
