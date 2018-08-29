package questions.leetcode731;

import java.util.ArrayList;
import java.util.List;
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

    private List<int[]> books = new ArrayList<>();
    public boolean book2(int s, int e) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] b : books)
            if (Math.max(b[0], s) < Math.min(b[1], e)) // overlap exist
                if (!overlaps.book(Math.max(b[0], s), Math.min(b[1], e))) return false; // overlaps overlapped
        books.add(new int[]{ s, e });
        return true;
    }

    private static class MyCalendar {
        List<int[]> books = new ArrayList<>();
        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
            books.add(new int[]{ start, end });
            return true;
        }
    }
}
