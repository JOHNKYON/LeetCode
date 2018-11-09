package questions.leetcode370;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update: updates) {
            res[update[0]] += update[2];
            if (update[1] < length-1)
                res[update[1]+1] -= update[2];
        }
        int curr = 0;

        for (int i=0; i<length; i++) {
            curr += res[i];
            res[i] = curr;
        }

        return res;
    }
}
