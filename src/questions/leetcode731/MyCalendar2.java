package questions.leetcode731;

import java.util.TreeMap;

public class MyCalendar2 {
    TreeMap<Integer, Integer> que;

    public void MyCalendarTwo() {
        que = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        que.put(start, que.getOrDefault(start, 0) + 1);
        que.put(end, que.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int i : que.values()){
            active += i;
            if (active >= 3){
                que.put(start, que.get(start) - 1);
                que.put(end, que.get(end) + 1);
                if (que.get(start) == 0)
                    que.remove(start);
                return false;
            }
        }
        return true;
    }
}
