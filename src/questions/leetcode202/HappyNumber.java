package questions.leetcode202;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n))
                return false;
            seen.add(n);
            int next = 0;
            while (n != 0) {
                int num = n % 10;
                next += num * num;
                n /= 10;
            }
            n = next;
        }
        return true;
    }
}
