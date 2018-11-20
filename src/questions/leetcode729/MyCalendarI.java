package questions.leetcode729;

import java.util.TreeSet;

public class MyCalendarI {
    TreeSet<Interval> set;
    public MyCalendarI() {
        set = new TreeSet<>();
    }

    public boolean book(int start, int end) {
        if (set.isEmpty())
            set.add(new Interval(start, end));
        else {
            Interval new_event = new Interval(start, end);
            Interval last = set.floor(new_event);
            Interval next = set.ceiling(new_event);
            if ((last == null || last.end <= start) &&
                    (next == null || next.start >= end)) {
                set.add(new_event);
                return true;
            } else
                return false;
        }
        return true;
    }

    private class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Interval b) {
            return start - b.start;
        }
    }
}
