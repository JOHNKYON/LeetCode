package questions.leetcode253;

import questions.dataStructure.Interval;

import java.util.Arrays;

public class MeetingRooms2 {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int res = 0;

        if (len == 0)   return res;

        int[] start = new int[len];
        int[] end = new int[len];

        for (int i=0; i<len; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int end_ptr = 0;
        for (int i=0; i<len; i++){
            if (start[i] < end[end_ptr])
                res++;
            else
                end_ptr++;
        }

        return res;
    }
}
