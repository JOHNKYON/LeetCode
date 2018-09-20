package questions.leetcode846;

import java.util.Arrays;

public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;

        int len = hand.length / W;
        Arrays.sort(hand);
        int[][] groups = new int[len][2];
        for (int i=0; i<len; i++) {
            groups[i][0] = -1;
        }

        for (int card: hand) {
            int curr = 0;
            for (int i=0; i<=len; i++) {
                if (i==len)
                    return false;
                if (groups[i][0] == -1) {
                    curr = i;
                    groups[i][0] = card;
                    break;
                }
                if (groups[i][1] == card-1 && groups[i][1] - groups[i][0] + 1 < W) {
                    curr = i;
                    break;
                }
            }

            groups[curr][1] = card;
        }
        return true;
    }
}
