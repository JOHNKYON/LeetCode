package questions.leetcode447;

import java.util.Arrays;

public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res = 0;

        double[][] distances = new double[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                distances[i][j] = calDistance(points[i], points[j]);
            }
        }

        for (double[] row: distances) {
            Arrays.sort(row);
            int count = 1;
            for (int i=1; i<n; i++) {
                if (equals(row[i], row[i-1]))
                    count++;
                else {
                    res += count * (count-1);
                    count = 1;
                }
            }
        }

        return res;
    }

    private double calDistance(int[] a, int[] b) {
        double x = (double)a[0] - b[0];
        double y = (double)a[1] - b[1];
        return Math.sqrt(x*x + y*y);
    }

    private boolean equals(double a, double b) {
        return (a - b < 1e-6) || (b-a < 1e-6);
    }
}
