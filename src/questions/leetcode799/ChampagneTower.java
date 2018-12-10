package questions.leetcode799;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][101];
        tower[0][0] = (double) poured;

        for (int r=0; r<100; r++) {
            for (int c=0; c<=query_row; c++) {
                double q = (tower[r][c] - 1.0) / 2;
                if (q > 0) {
                    tower[r+1][c] += q;
                    tower[r+1][c+1] += q;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}
