package questions.leetcode277;

import java.util.Arrays;

public class FindtheCelebrity {
    public int findCelebrity(int n) {
        int x=0;
        for (int i=0; i<n; i++) {
            if (knows(x, i))
                x=i;
        }
        for (int i=0; i<x; i++) {
            if (knows(x, i))
                return -1;
        }
        for (int i=0; i<n; i++) {
            if (!knows(i, x))
                return -1;
        }
        return x;
    }

    private boolean knows(int a, int b) {
        return false;
    }
}
