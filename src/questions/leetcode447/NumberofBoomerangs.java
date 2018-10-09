package questions.leetcode447;

import java.util.HashMap;

public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                int distance = (point1[0] - point2[0]) * (point1[0] - point2[0]);
                distance += (point1[1] - point2[1]) * (point1[1] - point2[1]);
                Integer count = map.get(distance);
                if (count != null) {
                    result += 2 * count;
                    map.put(distance, count + 1);
                } else {
                    map.put(distance, 1);
                }
            }
            map.clear();
        }
        return result;
    }
}
