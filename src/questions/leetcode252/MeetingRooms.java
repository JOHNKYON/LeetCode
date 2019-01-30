package questions.leetcode252;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int end = 0;
        for (Interval interval : intervals) {
            if (interval.start < end)
                return false;
            else
                end = interval.end;
        }
        return true;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public boolean canAttendMeetings2(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int end = 0;
        for (int i=0; i<intervals.length; i++) {
            if (intervals[i].start < end)
                return false;
            else
                end = intervals[i].end;
        }
        return true;
    }
}



