package questions.leetcode732;

import java.util.TreeMap;

public class MyCalendarIII {
    TreeMap<Integer, Integer> map;

    public MyCalendarIII() {
        map = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int ans = 0;
        int count = 0;
        for (int d: map.values()) {
            count += d;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
