package questions.leetcode475;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        if (heaters == null || heaters.length == 0)
            return 0;

        Arrays.sort(heaters);

        for (int house: houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index+1);
            }
            int dist1 = index - 1 >= 0? house - heaters[index-1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length? heaters[index] - house : Integer.MAX_VALUE;

            radius = Math.max(radius, Math.min(dist1, dist2));
        }

        return radius;
    }
}
