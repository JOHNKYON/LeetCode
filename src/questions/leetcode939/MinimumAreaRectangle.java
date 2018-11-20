package questions.leetcode939;

import java.util.*;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for (int[] point: points) {
            int x = point[0], y = point[1];
            rows.computeIfAbsent(x, z-> new ArrayList()).add(y);
        }
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> lastx = new HashMap();
        for (int x: rows.keySet()) {
            List<Integer> row = rows.get(x);
            Collections.sort(row);
            for (int i=0; i<row.size(); i++)
                for (int j=i+1; j<row.size(); j++) {
                    int y1 = row.get(i), y2 = row.get(j);
                    int code = 40001 * y1 +y2;
                    if (lastx.containsKey(code))
                        res = Math.min(res, (x-lastx.get(code)) * (y2-y1));
                    lastx.put(code, x);
                }
        }

        return res < Integer.MAX_VALUE? res: 0;
    }
}
