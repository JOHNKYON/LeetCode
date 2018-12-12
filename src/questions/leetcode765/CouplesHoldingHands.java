package questions.leetcode765;

public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] positions = new int[n];

        for (int i=0; i<n; i++) {
            positions[row[i]] = i;
        }
        int ans = 0;

        for (int i=0; i<n; i += 2) {
            int c1 = row[i];
            int c2;
            if ((row[i] & 1) == 0)
                c2 = c1+1;
            else
                c2 = c1-1;
            if (row[i+1] != c2) {
                ans++;
                swap(row, positions, i+1, c2);
            }
        }
        return ans;
    }

    private void swap(int[] row, int[] positions, int a_i, int b) {
        int a = row[a_i];
        int b_i = positions[b];

        int temp = row[b_i];
        row[b_i] = row[a_i];
        row[a_i] = temp;

        positions[b] = a_i;
        positions[a] = b_i;
    }
}
