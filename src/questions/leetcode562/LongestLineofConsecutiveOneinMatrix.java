package questions.leetcode562;

public class LongestLineofConsecutiveOneinMatrix {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0)
            return 0;

        int ans = 0;

        // 0: verical, 1: horizontal, 2: left up, 3: right up
        int[][][] counts = new int[M.length][M[0].length][4];


        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M[0].length; j++) {
                if (M[i][j] == 1) {
                    for (int k=0; k<4; k++) {
                        counts[i][j][k] = 1;
                        if (k == 0) {
                            if (i > 0) {
                                counts[i][j][k] = counts[i-1][j][k] + 1;
                            }
                        } if (k == 1) {
                            if (j > 0) {
                                counts[i][j][k] = counts[i][j-1][k] + 1;
                            }
                        } if (k == 2) {
                            if (i > 0 && j > 0) {
                                counts[i][j][k] = counts[i-1][j-1][k] + 1;
                            }
                        } if (k == 3) {
                            if (i > 0 && j < M[0].length-1) {
                                counts[i][j][k] = counts[i-1][j+1][k] + 1;
                            }
                        }
                    }
                    for (int k=0; k<4; k++) {
                        ans = Math.max(ans, counts[i][j][k]);
                    }
                }
            }
        }
        return ans;
    }
}
