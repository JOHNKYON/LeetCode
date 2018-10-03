package questions.leetcode774;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimizeMaxDistancetoGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);

        double left = 0;
        double right = 1e8;
        double mid = (left + right) / 2.0;

        while (right - left > 1e-6) {
            mid = (left + right) / 2;
            boolean flag = possible(mid, stations, K);
            if (flag) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return mid;
    }

    private boolean possible(double mid, int[] stations, int k) {
        int count = 0;
        for (int i=0; i<stations.length-1; i++) {
            count += (int) ((stations[i+1] - stations[i]) / mid);
            if (count > k)
                return false;
        }
        return true;
    }
}
