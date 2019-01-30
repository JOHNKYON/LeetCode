package questions.leetcode252;

import java.util.Arrays;

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
}



